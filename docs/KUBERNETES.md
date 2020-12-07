# Kubernetes

## Demo application in kubernetes
- microk8s kubectl create deployment demo --image=demo_image

## Mongodb image in kubernetes
- microk8s kubectl create deployment demo --image=demo_image

## How to get token for kubernetes
token=$(microk8s kubectl -n kube-system get secret | grep default-token | cut -d " " -f1)
microk8s kubectl -n kube-system describe secret $token