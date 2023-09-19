variable "project_id" {
  type = string
}

variable "region" {
  type = string
}

variable "zone" {
  type = string
}

variable "service_account" {
  type = string
}

variable "terraform_state_bucket" {
  type = string
  default = "tf-state"
}

variable "gcp_service_list" {
  description = "List of GCP service to be enabled for a project."
  type        = list(string)
}