terraform {
  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "4.51.0"
    }
  }
}


#terraform {
#  backend "gcs" {
#    bucket = "${var.project_id}-bucket-tfstate"
#    prefix = "terraform/state"
#  }
#}