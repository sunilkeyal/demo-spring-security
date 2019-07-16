This is Demo application for shopping cart using Spring boot

* The application can be run as a simple spring boot app and the UI is hosted at
  http://localhost:8080.
  
* Currently it displys sample UI (It works!) which cann be extended for more UI functionalities.

It has the following REST Controller methods. The controller can be tested using POSTMAN or any other REST test client.

 * getTotalPrice : This method takes a list of fruits and return total cost
                    This method returns deal for (buy one apple get one free, buy two orange and get one free)
 
To TEST using POSTMAN use the folling
 * start spring boot application
 * Use this URL in POSTMAN : localhost:8080/items/totalprice
 * Use method body with json string ["orange", "apple", "apple"] 
 * See the total amount in pence being returned.


