This is Demo application for various POCs. The UI is hosted at http://localhost:8080

# Rest Controller
- The application has the following REST Controller methods. There are service tests to validate the business methods.
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
 
# Swagger
- Swagger can be accessed at http://localhost:8080/swagger-ui.html

# Docker
Docker can build image by reading the instructions from a Dockerfile.

- To build an image (demo_image)
    $ ./gradlew clean build  (always clean build before creating image)
    $ docker build -t demo_image . 
    
- To see the list of images    
    $ docker images
    
- To create and start a named container "demo_container" 
    $ docker run -p 7070:7070 --env MYSQL_HOST=host.docker.internal --env MYSQL_USERNAME=root --env MYSQL_PASSWORD=root --name demo_container demo_image:latest 
    
- To create and start a container with a random container name.  
    $ docker run -p 7070:7070 --env MYSQL_HOST=host.docker.internal --env MYSQL_USERNAME=root --env MYSQL_PASSWORD=root demo_image:latest
   
- To see list of containers. -a flag will display all (active and inactive)
    $ docker ps -a
             
- To login to the container
    $ docker exec -it demo_container /bin/sh
    
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
- Added Spring security with basic authentication
    - Secured /customers REST endpoints  
- The endpoints are
    - http://localhost:7070/oauth/token (POST)
    - http://localhost:7070/users (POST)
    - http://localhost:7070/users (GET)
    - http://localhost:7070/api/v1/customers (POST)
    - http://localhost:7070/api/v1/customers (GET)

# JMS (ActiveMQ)
- Added JMS Sender and Receiver 
    - Create customer Service creates customer in DB 
    - Sends message to JMS queue
    - JMS Receiver gets the Message and update customer with JMS status
             