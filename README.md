This is Demo application for various POCs. The UI is hosted at http://localhost:8080

# Swagger
- Swagger can be accessed at http://localhost:8080/swagger-ui.html




# Docker 
## Image from Dockerfile 
We can build a docker image by reading  instructions from a Dockerfile as follows 

- Clean build the application first
    - $ ./gradlew clean build
- Create docker image (demo_image)
    - $ docker build -t demo_image .
    
## Docker commands
- To see the list of images    
    - $ docker images

- To create a named docker container (call it : demo_container) from an image and start
    - $ docker run -p 7070:7070 --env MYSQL_HOST=host.docker.internal --env MYSQL_USERNAME=root --env MYSQL_PASSWORD=root --name demo_container demo_image:latest 
    
- To create a docker container with a random container name and start   
    - $ docker run -p 7070:7070 --env MYSQL_HOST=host.docker.internal --env MYSQL_USERNAME=root --env MYSQL_PASSWORD=root demo_image:latest
   
- To see a list of containers
    - $ docker ps -a (-a flag will display all active and inactive)
             
- To login to the demo_container
    - $ docker exec -it demo_container /bin/sh
    
- A One liner to build demo_image, create demo_container, and start it
    - $ ./gradlew build; docker build -t demo_image . ; docker rm --force demo_container; docker run -p 7070:7070 --env MYSQL_HOST=host.docker.internal --env MYSQL_USERNAME=root --env MYSQL_PASSWORD=root --name demo_container demo_image:latest 
    
## Kafka in docker
Use the following commands to create a kafka instance inside docker.

Create a network called kafka-net
- docker network create kafka-net

Delete zookeeper-server if it already exists
- docker rm --force zookeeper-server

Download docker image (bitnami/zookeeper) and  create zookeeper-server docker container and start them
- docker run -d --name zookeeper-server --network kafka-net -p 2181:2181 -e ALLOW_ANONYMOUS_LOGIN=yes bitnami/zookeeper

 /TODO run cluster of Zookeeper (called ensembles)
 
 Delete kafka-server1 and kafka-server2 if ithey already exist
- docker rm --force kafka-server1
- docker rm --force kafka-server2

Download bitnami/kafka docker image and create two containers (kafka-server1, and kafka-server2) and start them
- docker run -d --name kafka-server1 --network kafka-net -e ALLOW_PLAINTEXT_LISTENER=yes -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper-server:2181 -e KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -p 9092:9092 bitnami/kafka:latest
- docker run -d --name kafka-server2 --network kafka-net -e ALLOW_PLAINTEXT_LISTENER=yes -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper-server:2181 -e KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9093 -p 9093:9092 bitnami/kafka:latest

//TODO NOTE: server2 is not working. Make it work.

Download Zookeeper Navigation docker image elkozmon/zoonavigator and create docker container zoonavigator and start
- docker run -d --network kafka-net -e HTTP_PORT=9000 -p 9000:9000 --name zoonavigator elkozmon/zoonavigator:latest
 
## MongoDB in docker
- Download mongo image, create docker container (named mongodb),
- attach the /home/skeyal/Projects/demo/mongodb/data host volume to the /data/db container volume
    - docker run --name mongodb -p 27017:27017 -d mongo

## ActiveMQ in docker
- docker run --name activemq -p 61616:61616 -p 8161:8161 -d rmohr/activemq    
  
## Elastic Search in docker
- docker run --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -d docker.elastic.co/elasticsearch/elasticsearch:7.8.0  

## Docker Compose
All the above manual steps can be replaced with docker-compose.yml file
- https://docs.docker.com/compose/reference/overview/
- Run the following command from project root to build and start containers defined in docker-compose.yml
- docker-compose.yml file can be used to replace all the manual steps above as follows by running the following commands
    - docker-compose up -d (-d for detached mode; docker-compose.yml is default)
    - docker-compose -f docker-compose.yml up -d
    - docker-compose down  (to stop and delete containers)  



# Angular
- Install the following in Ubuntu
    - sudo apt install nodejs
    - sudo apt install npm
    - npm install -g @angular/cli
- Angular/cli can be used to create new project.
- Tour of Heros project added  from project root
    - ng new ui
- Created client project from project root (https://www.baeldung.com/spring-boot-angular-web)
    - ng new client
    - create model directory and go inside and run "ng generate class customer"
    - create service directory and go inside and run "ng generate service customer"
    - change to client directory
    - ng generate component customer-list
    - ng generate component customer-form
- Adding security to client project. List customer won't display the customer list without login first.   
    - ng g component login
    - ng g service api
    
    
    
# Spring Data JPA and Lombok
- Spring data jpa added
- Lombok added



# Spring Security
- Added Spring security with oauth2
    - Secured /api/** REST endpoint resources 
- The endpoints are
    - http://localhost:8080/oauth/token (POST)
    - http://localhost:8080/users (POST)
    - http://localhost:8080/users (GET)
    - http://localhost:8080/api/v1/customers (POST)
    - http://localhost:8080/api/v1/customers (GET)
    

    
# JMS (ActiveMQ)
- Added JMS Sender and Receiver 
    - Create customer Service creates customer in DB 
    - Sends message to JMS queue
    - JMS Receiver gets the Message and update customer with JMS status


        
# Flyway
- Added flyway db migration



# Controllers
## Sales Controller
- The application has the following methods in SalesController. There are service tests to validate the business methods.
    - getTotalPrice : This method takes a list of fruits and returns total cost without any offer
    - getTotalPriceWithAppleOffer : This method takes a list of fruits and returns total cost with buy one get one free apple offer
    - getTotalPriceWithOrangeOffer : This method takes a list of fruits and returns total cost with buy two get one free orange offer
    - getTotalPriceWithAllOffer : This method takes a list of fruits and returns total cost with both apple and orange offers.

- The controller can be tested using POSTMAN or any other REST test clients. To TEST using POSTMAN use the following
    - start spring boot application
    - Use the following URLs in POSTMAN :
        - http://localhost:8080/cart/total
        - http://localhost:8080/cart/total/offer/apple
        - http://localhost:8080/cart/total/offer/orange
        - http://localhost:8080/cart/total/offer/all
    - Use method body with json string for example : ["orange", "apple", "apple"]
    - See the total amount in pence being returned.
 
## Customer Controller
- It contains customer REST endpoints

## Test Controller
- A test controller http://localhost:8080/test . It returns "Hello World"



# Kubernetes

## Demo application in kubernetes
- microk8s kubectl create deployment demo --image=demo_image

## Mongodb image in kubernetes
- microk8s kubectl create deployment demo --image=demo_image 

## How to get token for kubernetes
token=$(microk8s kubectl -n kube-system get secret | grep default-token | cut -d " " -f1)
microk8s kubectl -n kube-system describe secret $token


eyJhbGciOiJSUzI1NiIsImtpZCI6IndScnRTaTdRZElsN1FOTzVwTG1YV3J6djFHUFotbkpOX0t4NzFoQ3prZmcifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJkZWZhdWx0LXRva2VuLThmZ2d0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImRlZmF1bHQiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiJmMDE2MjNiZi0xMGZiLTQ4MzgtYmZmYy02OTdjYjg4Y2JkYTUiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZS1zeXN0ZW06ZGVmYXVsdCJ9.KfpXQi2hYiXGW0nuJDCoMdqzxz4WkIzbWaB_denq_lbPZC6fCDsgyi4iLsq1TjbYUaVo3uP5zQg0Nlwpk-EGlRgze1QMv22hDlKCmTFUoe9I6IDOMvlk-7-A5SqsMOT1zQNhBsP_FHo4Q4fyf4r1_H-3BG_uBXwQQlFqE2Joh8YxA_BFT7URIIMjh3lJDs1zceR2cch2jg0hXJsSfeMQ5aVNl4QH_kOJgWAOxaXF9sftySF2Z9RPWUj8vfB0sSEJkWtG_N2fjDfJfoRRoszVyAZt5LOPNrAdm04thIZ7Y2Gy92rA0-dj1h0viGknp5gN2HdfH1QgFzfo9VEon0W6zw

