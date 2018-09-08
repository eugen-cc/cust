### Simple Customer Management

This demo is based on a Spring Boot application. 

Used frameworks:
* Spring Boot
* Spring MVC
* Spring Data
* Thymeleaf
* Apache Maven
##
##### BUILD and RUN
Please run the build on the parent project and excecute the jar file in the target folder of the web subproject 
 
```sh
$ cd customer
$ mvn clean install
$ java -jar web/target/webapp-1.0.0.jar
```

Check
[http://localhost:8080](http://localhost:8080)  
##
##### DATABASE
This Demo is using a *H2 in-memory database* !  
To view the data visit :  [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

Login with credentials configured in **application.properties**

| JDBC URL | USER | PASS |
| ------ | ------ | -----|
| jdbc:h2:mem:customerdb | dba | -|


##
##### NOT IN SCOPE
Topics like Security and Validation are out of scope in this demo.
