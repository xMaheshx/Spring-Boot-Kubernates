project_id       = "sodium-pattern-396412"
region           = "europe-north1"
zone             = "europe-north1-a"
service_account  = "terraform@sodium-pattern-396412.iam.gserviceaccount.com"
gcp_service_list = [
  "compute.googleapis.com", # Compute Engine API
  "storage.googleapis.com", # Cloud Storage API
  "artifactregistry.googleapis.com", # Artifact Registry API
  "run.googleapis.com" # Cloud Run API
]