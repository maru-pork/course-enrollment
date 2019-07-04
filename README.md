Angular 7 + Microservices with Spring Boot and Spring Cloud
[Udemy](https://www.udemy.com/angular-7-microservices-with-spring-boot-and-spring-cloud/)

**Why Not Monolithic?**
- Error Effect
- Technology Dependency
- CI/CD Processes
- Big Databases

**Why Microservices?**
- Not for small projects
- Technology Independent
- CI/CD Processes
- Error Handle
- Scalability

```
npm install -g @angular/cli
ng new my-app-name
ng serve
```
 
**User Service - Microservice 1**  
  
**Spring Dependency Injection**
1. Constructors
2. Setters
3. Fields (@Autowired)

**Spring Components**  
*@Component @Repository @Service @Controller*

*@SpringBootApplication*
*@Transactional*

https://start.spring.io/  
**Dependencies**
1. Spring Web Starter
2. Spring Security
3. Spring Data JPA
4. Rest Repositories
5. Liquibase Migration
6. MySQL Driver
7. Eureka Discovery Client
8. Lombok

https://www.liquibase.org/documentation/xml_format.html 

https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS

- Cross-Origin Resource Sharing (CORS) is a mechanism that uses additional HTTP headers to tell a browser to let a web application running at one origin (domain) have permission to access selected resources from a server at a different origin.
- Cross-Site Request Forgery (CSRF) is an attack that forces an end user to execute unwanted actions on a web application in which they're currently authenticated. 

**Login**
- Form Payload
- HTTPHeaders (using base64 token)


Intellij > Settings > Annotation Processors > Enable Annotation Processing