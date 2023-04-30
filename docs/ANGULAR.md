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

# Spring Security
- Spring security with oauth2
  - Secured /api/** REST endpoint resources
- The endpoints are
  - http://localhost:8080/oauth/token (POST)
  - http://localhost:8080/users (POST)
  - http://localhost:8080/users (GET)
  - http://localhost:8080/api/v1/customers (POST)
  - http://localhost:8080/api/v1/customers (GET)    


