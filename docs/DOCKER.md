# Docker
## Build Image from Dockerfile
Docker default size is 2 GB, which is not sufficient for so many servers to run inside. Increase to at least 4 GB. How???
Docker image is built by reading instructions from a Dockerfile
Clean build the application first to include the latest application jar and then create docker image as follows

- $ ./gradlew clean build
- $ docker build -t demo_image . (Creates demo_image)

## Some useful docker commands
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

## Kafka in docker (Use docker-compose instead)
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

## MongoDB in docker (Use docker-compose instead)
- Download mongo image, create docker container (named mongodb),
- attach the /home/skeyal/Projects/demo/mongodb/data host volume to the /data/db container volume
    - docker run --name mongodb -p 27017:27017 -d mongo

## ActiveMQ in docker (Use docker-compose instead)
- docker run --name activemq -p 61616:61616 -p 8161:8161 -d rmohr/activemq

## Elastic Search in docker (Use docker-compose instead)
- docker run --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -d docker.elastic.co/elasticsearch/elasticsearch:7.8.0

## Volumes in docker (Use docker-compose instead)
- By default, volumes will be created in /var/lib/docker/volumes folder (in Ubuntu).  Mac not sure...
- It can be created directly using following commands or use docker-compose
    - docker volume create my-volume
    - docker volume ls
    - docker volume rm my-volume
- The command "docker-compose down" won't remove data if we use volumes. See mysql-storage, grafana-storage as examples inside docker-compose.yml.


## Docker Compose
All the above manual steps can be replaced with docker-compose.yml file
- https://docs.docker.com/compose/reference/overview/
- Run the following command from project root to build and start containers defined in docker-compose.yml
- docker-compose.yml file can be used to replace all the manual steps above as follows by running the following commands
    - docker-compose up -d (-d for detached mode; docker-compose.yml is default)
    - docker-compose -f docker-compose.yml up -d
    - docker-compose down  (to stop and delete containers)  