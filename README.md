# Spring Boot :pencil2: REST API

## About Spring Boot and this example

[Spring Boot](https://spring.io/projects/spring-boot) allows you to create stand-alone Spring applications by embedding an application server.

It provides production-ready features like metrics or health-checks and simplifies the build configuration overall.

In this example you can check how to create an REST API in a Spring Boot application.

A REST API is an application programming interface that follows the REST architectural style and allows for interaction with RESTful web services. REST stands for representational state transfer.

## Technical requirements

The only requirement is that you have a running Spring Boot application. If you need some help at setting it up you can check how  [in this example](https://github.com/codewithhades/spring-boot-basic-setup).

## How to create the REST API

To create a REST API we simply need to annotate a class with @RestController and add the path where the REST API will be mapped.

````java
@RestController
@RequestMapping("/api/users")
````
Then it is just a matter of adding your REST API methods as we did with [UsersController](src/main/java/com/codewithhades/springboot/restapi/users/UsersController.java).

REST API methods inherit the base REST API path and can optionally concat their own path as well as use path variables.

````java
@GetMapping("/{id}")
````
They also support request body parameter, content type headers, validations and many more.

````java
@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest){...}
````

We will also add a [UsersControllerTest](src/test/java/com/codewithhades/springboot/restapi/users/UsersControllerTest.java) in order to check that the REST API behaves as expected.


## How to run it

Once your SpringBoot application is running you can operate the REST API by calling it from a terminal

````bash
# To add an users
curl -X POST localhost:8080/app/api/users -H "Content-Type: application/json" -d '{"name": "Anakin","surname":"Skywalker"}'
# To list all users
curl localhost:8080/app/api/users
# To list an user by ID (which you can find by listing all)
curl localhost:8080/app/api/users/8a53a7da-ec0c-4d68-ab0a-d12e16013348
# To update an user by ID (which you can find by listing all)
curl -X PUT localhost:8080/app/api/users/8a53a7da-ec0c-4d68-ab0a-d12e16013348 -H "Content-Type: application/json" -d '{"name": "Darth","surname":"Vader"}'
# To delete an user by ID (which you can find by listing all)
curl -X DELETE localhost:8080/app/api/users/8a53a7da-ec0c-4d68-ab0a-d12e16013348
````
I hope you found this example useful!

:coffee: May Java be with you!