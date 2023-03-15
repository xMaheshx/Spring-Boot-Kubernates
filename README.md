
# Deployment
## Running Locally with Podman

### Build/Tag your image
`podman build -t products-api:v1 .`

### Create a pod
`podman run -dt --pod new:products-api -p 8081:8080 products-api:v1`

### Stop and Delete pod
`podman pod stop products-api`

`podman pod rm products-api`

### Create a pod using yaml
`podman play kube .\products-api-deployment.yaml`

### Delete pod created using yaml
`podman kube down .\products-api-deployment.yaml`


## Prepare Artifact Registry in GCP

### Create a new image registry in Artifact Registry in GCP
`gcloud artifacts repositories create images --repository-format=docker --location=europe-north1 --description="Docker repository"`


### Login to Registry
`gcloud auth print-access-token |
podman login -u oauth2accesstoken --password-stdin https://europe-north1-docker.pkg.dev`

### Build/Tag and Push your image
`podman build -t europe-north1-docker.pkg.dev/<PROJECT>/images/products-api:v1 .`

`podman push europe-north1-docker.pkg.dev/<PROJECT>/images/products-api:v1`

## Deploy App to Kubernates

### Create Cluster
`gcloud container clusters create-auto my-products-cluster --region=europe-north1`

### Configure kubectl to use your new cluster
`gcloud container clusters get-credentials my-products-cluster --region europe-north1`

### Create Deployment
`kubectl create deployment products-api --image=europe-north1-docker.pkg.dev/<PROJECT>/images/products-api:v1`

### Expose Deployment
`kubectl expose deployment products-api --type LoadBalancer --port 80 --target-port 8080`

### Inspect
`kubectl get pods`

`kubectl get service products-api`

## Updating App

### Build and Push new Image
`podman build -t europe-north1-docker.pkg.dev/<PROJECT>/images/products-api:v2 .`

`podman push europe-north1-docker.pkg.dev/<PROJECT>/images/products-api:v2`

### Perform Rolling Update
`kubectl set image deployment products-api products-api=europe-north1-docker.pkg.dev/<PROJECT>/images/products-api:v1`

### Verify Rolling Update
`kubectl rollout status deployment products-api`

### Troubleshooting
`gcloud components install gke-gcloud-auth-plugin`

## Clean up
`kubectl delete deploymentn products-api`

`gcloud container clusters delete my-products-cluster --region europe-north1`

`gcloud artifacts repositories delete images --location=europe-north1`

