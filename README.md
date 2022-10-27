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
@RequestMapping("/api/users")
public class UsersController{
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
@RequestMapping("/api/users")
public class UsersController{
}
````

## Cómo arrancarlo