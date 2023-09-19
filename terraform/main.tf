provider "google" {
  project = var.project_id
  region  = var.region
  zone    = var.zone
}


module "setup" {
  source                 = "./modules/setup"
  gcp_service_list       = var.gcp_service_list
  service_account        = var.service_account
  region                 = var.region
  project_id             = var.project_id
  terraform_state_bucket = var.terraform_state_bucket
}