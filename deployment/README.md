# Deployment info

Here is the info about how to deploy the system to kubernetes.

### You'll need to have:

- kubernetes cluster installed
- container image building tool (Docker)

### Current possibilities:

One deployment consisting of:
- postgres database filled with sample data
- micro-products and micro-orders services connected to the mentioned database

### In progress:


## How to deploy the system

1. Run `deploy-all.bat` (Windows) or `deploy-all.sh` script (Linux)
2. Get minikube cluster IP by running `minikube ip`
3. Application should be accessible at
`<minikube-ip>:31111` (product service) and `<minikube-ip:31112>` (orders service)

If you can't send requests to the app, try to forward ports:
- for product service run `kubectl port-forward svc/micro-products-service 31111:8080`.
Then request the service at `localhost:31111`

### How to update container images

To update container images apply the following procedure for each container image:
1. From the deployment directory, build the container image with new tag
   1. `docker build -t <username/image-name:img-tag> -f .\Dockerfile-orders ..`
2. Push the image to the registry: `docker image push <username/img-name:img-tag>`
3. Update image tag in specific deployment .yaml file.