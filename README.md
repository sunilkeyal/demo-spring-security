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
Docker image can be created using Dockerfile 
- To create docker image, run the following command from the project root
    - docker build -t mydemoimage . 
- To create a docker container from the above image, run the following command from project root   
    - docker run -p 8080:8080 --name mydemocontainer mydemoimage 
