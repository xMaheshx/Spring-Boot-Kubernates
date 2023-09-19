# Service account impersonation
provider "google" {
  alias  = "impersonation"
  scopes = [
    "https://www.googleapis.com/auth/cloud-platform",
    "https://www.googleapis.com/auth/userinfo.email",
  ]
}

data "google_service_account_access_token" "default" {
  provider               = google.impersonation
  target_service_account = var.service_account
  scopes                 = ["userinfo-email", "cloud-platform"]
}

# Terraform state GCS
resource "google_storage_bucket" "default" {
  name                        = "${var.project_id}-bucket-tfstate"
  force_destroy               = true
  location                    = var.region
  storage_class               = "STANDARD"
  public_access_prevention    = "enforced"
  uniform_bucket_level_access = true
  versioning {
    enabled = true
  }
  depends_on = [google_project_service.gcp_services]
}

# Artifact registry
resource "google_artifact_registry_repository" "artifacts" {
  location      = var.region
  repository_id = "images"
  format        = "DOCKER"
}


# Enable required services
resource "google_project_service" "gcp_services" {
  count                      = length(var.gcp_service_list)
  service                    = var.gcp_service_list[count.index]
  disable_dependent_services = true
}