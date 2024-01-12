@echo off

echo Cleaning minikube environment...
kubectl delete deployment micro-products-deploy micro-orders-deploy micro-postgres-deploy
kubectl delete service micro-products-service micro-orders-service micro-postgres-service

echo Minikube cleaning complete.