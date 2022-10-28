# :uk: Spring Boot :pencil2: API

## About Spring Boot

[Spring Boot](https://spring.io/projects/spring-boot) allows you to create stand-alone Spring applications by embedding an application server.

It provides production-ready features like metrics or health-checks and simplifies the build configuration overall.

## About this example

In this example you can check how to create an API in a Spring Boot application.

You can check how to set a Spring Boot application up with the basics [in this example](https://github.com/codewithhades/spring-boot-basic-setup).

## How to create the API

To create an API we simply need to annotate a class with @RestController and add the path where the API will be mapped.

````java
@RestController
@RequestMapping("/your_api_path")
````
Then it is just a matter of adding your API methods as we did with [UsersController](src/main/java/com/codewithhades/springboot/api/users/UsersController.java).

API methods inherit the base API path and they can optionally concat their own path.

They also support path variables, request body parameter, content type headers and many more.

````java
@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {
}
````


## How to run it

---

# :es: Spring Boot :pencil2: API

## Acerca de Spring Boot

[Spring Boot](https://spring.io/projects/spring-boot) te ofrece la posibilidad de crear aplicaciones Spring que son independientes al contener embebido un servidor de aplicaciones.

Proporciona herramientas listas para producción como métricas o health-checks, y simplifica la configuración en general.

## Acerca de este proyecto

En este ejemplo podrás ver cómo crear una API en una aplicación Spring Boot.

Puedes ver cómo configurar una aplicación Spring Boot con lo básico [en este ejemplo](https://github.com/codewithhades/spring-boot-basic-setup).

## Cómo crear la API

Para crear una API simplemente necesitamos anotar una clase con @RestController y añadir el path donde se mapeará la API.

````java
@RestController
@RequestMapping("/tu_API_path")
````

Una vez anotada es cuestión de añadir tus métodos API como hemos hecho en [UsersController](src/main/java/com/codewithhades/springboot/api/users/UsersController.java).

Los métodos API heredan el path base de la API y pueden opcionalmente concatenar su propio path.

También soportan variables en el path, parámetro para el body de la petición, tipo de contenido como abecera y mucho más.

````java
@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {
}
````

## Cómo arrancarlo