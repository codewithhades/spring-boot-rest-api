# :uk: Spring Boot :pencil2: API

## About Spring Boot

[Spring Boot](https://spring.io/projects/spring-boot) allows you to create stand-alone Spring applications by embedding an application server.

It provides production-ready features like metrics or health-checks and simplifies the build configuration overall.

## About this example

In this example you can check how to create an API (Application Programming Interface) in a Spring Boot application.

But before we continue you need to set a Spring Boot application up. If you need some help you can check how  [in this example](https://github.com/codewithhades/spring-boot-basic-setup).

## How to create the API

To create an API we simply need to annotate a class with @RestController and add the path where the API will be mapped.

````java
@RestController
@RequestMapping("/your_api_path")
````
Then it is just a matter of adding your API methods as we did with [UsersController](src/main/java/com/codewithhades/springboot/api/users/UsersController.java).

API methods inherit the base API path and can optionally concat their own path.

They also support path variables, request body parameter, content type headers and many more.

````java
@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {
}
````

We will also add a [UsersControllerTest](src/test/java/com/codewithhades/springboot/api/users/UsersControllerTest.java) in order to check that the API behaves as expected.


## How to run it

Once your SpringBoot application is running you can operate the API by calling it from a terminal

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

---

# :es: Spring Boot :pencil2: API

## Acerca de Spring Boot

[Spring Boot](https://spring.io/projects/spring-boot) te ofrece la posibilidad de crear aplicaciones Spring que son independientes al contener embebido un servidor de aplicaciones.

Proporciona herramientas listas para producción como métricas o health-checks, y simplifica la configuración en general.

## Acerca de este proyecto

En este ejemplo podrás ver cómo crear una API (Application Programming Interface) en una aplicación Spring Boot.

Pero antes que nada, necesitarás tener configurada una aplicación Spring Boot. Si necesitas ayuda con esto puedes ver cómo hacerlo [en este ejemplo](https://github.com/codewithhades/spring-boot-basic-setup).

## Cómo crear la API

Para crear una API simplemente necesitamos anotar una clase con @RestController y añadir el path donde se mapeará la API.

````java
@RestController
@RequestMapping("/tu_API_path")
````

Una vez anotada es cuestión de añadir tus métodos API como hemos hecho en [UsersController](src/main/java/com/codewithhades/springboot/api/users/UsersController.java).

Los métodos API heredan el path de base de la API y pueden opcionalmente concatenar su propio path.

También soportan variables en el path, parámetro para el body de la petición, tipo de contenido como cabecera y mucho más.

````java
@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {
}
````

También añadiremos un [UsersControllerTest](src/test/java/com/codewithhades/springboot/api/users/UsersControllerTest.java) para corroborar que nuestra API funciona como se espera.

## Cómo arrancarlo

Una vez arrancada tu aplicación Spring Boot puedes operar con la API llamándola desde un terminal
````bash
# Para añadir un usuario
curl -X POST localhost:8080/app/api/users -H "Content-Type: application/json" -d '{"name": "Anakin","surname":"Skywalker"}'
# Para listar los usuarios
curl localhost:8080/app/api/users
# Para listar un usuario por ID (que podrás encontrar al listarlos)
curl localhost:8080/app/api/users/8a53a7da-ec0c-4d68-ab0a-d12e16013348
# Para modificar un usuario por ID (que podrás encontrar al listarlos)
curl -X PUT localhost:8080/app/api/users/8a53a7da-ec0c-4d68-ab0a-d12e16013348 -H "Content-Type: application/json" -d '{"name": "Darth","surname":"Vader"}'
# Para borrar un usuario por ID (que podrás encontrar al listarlos)
curl -X DELETE localhost:8080/app/api/users/8a53a7da-ec0c-4d68-ab0a-d12e16013348
````

¡Espero que te haya sido útil este ejemplo!

:coffee: ¡Que Java te acompañe!