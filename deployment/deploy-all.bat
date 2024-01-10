@echo off

echo Applying database deployment...
kubectl apply -f .\postgres-deployment.yaml

echo Applying services deployment...
kubectl apply -f .\services-deployment.yaml

echo Deployment complete.