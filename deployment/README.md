# Deployment info

Here is the info about how to deploy the system to kubernetes.

#### You'll need to have:

- kubernetes cluster installed
- container image building tool (Docker)

### Current possibilities:

- deployment of postgres database filled with sample data

### In progress:

- micro-products service deployment

## How to deploy the system

1. To update container images apply the following procedure for each container image:
   1. Build the container image with new tag
   2. Push the image to the registry: `docker image push <img-name:img-tag>`
   3. Update image tag in specific deployment .yaml file.
2. Run `kubectl apply -f postgres-deployment.yaml`
3. Run `kubectl apply -f micro-products-deployment.yaml`