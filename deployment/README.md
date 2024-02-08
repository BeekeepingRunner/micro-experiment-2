# Deployment info

Here is the info about how to deploy the system to kubernetes.

### You'll need to have:

- kubernetes cluster installed
- container image building tool (Docker)

### Current possibilities:

One deployment consisting of:
- postgres database filled with sample data
- micro-products and micro-orders services connected to the mentioned database

## How to deploy the system

1. Add ingress to minikube: `minikube addons enable ingress`
2. Run `deploy-all.bat` (Windows) or `deploy-all.sh` script (Linux)
3. Tunnel a connection: `minikube tunnel`
4. Application should be accessible at `localhost/products` (product service)
   and `localhost/orders` (orders service)

### Useful commands for cluster monitoring
- `kubectl get nodes`
- `kubectl get pods`
- `kubectl get deployments`
- `kubectl get services`
- `minikube ip`

For debugging - tail logs (assumes stern installed):
- `kubectl stern deployment/micro-orders-deploy`
- `kubectl stern deployment/micro-products-deploy`
- `kubectl stern deployment/micro-postgres-deploy`

### How to update container images

To update container images apply the following procedure for each container image:
1. From the deployment directory, build the container image with new tag
   - `docker build -t <repository>/micro-orders:<version> -f .\Dockerfile-orders ..`
   - `docker build -t <repository>/micro-products:<version> -f .\Dockerfile-products ..`
   - `docker build -t <repository>/micro-postgres:<version> -f .\Dockerfile-postgres .`
2. Push the image to the registry: `docker image push <repository>/<img-name:img-tag>`
3. Update image tag in specific deployment .yaml file.