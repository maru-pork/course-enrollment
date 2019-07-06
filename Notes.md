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
 
## I. Microservice User Management
  
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

## II. Microservice Log Management
**Dependencies**
1. Spring Web Starter
2. Spring Data JPA
4. Rest Repositories
5. Spring Data Apache Cassandra
6. Eureka Discovery Client
7. Lombok

*Primary Key Attributes in SQL*
```
create table mytable (
	id int auto_increment,
	primary key(id)
);
```

*Primary Keys in Cassandra*
- Partition (single field key)
- Composite (multiple column key)
```
create table mytable (
	id int,
	name text,
	primary key(id, name)
);
```
- Cluster (responsible for data sorting within their partition)
```
create table mytable (
	id int,
	name text,
	primary key((id), name)	
) WITH CLUSTERING name (order by DESC); 
```

start cassandra
```
> cassandra.bat
```

JpaRepository vs CrudRepository [Reference](https://www.baeldung.com/spring-data-repositories)
- CrudRepository provides CRUD functions
- PagingAndSortingRepository provides methods to do pagination and sort records
- JpaRepository provides JPA related methods such as flushing the persistence context and delete records in a batch
- JpaRepository contains the full API of CrudRepository and PagingAndSortingRepository

```
Error: no property findPopularCourses found for type Summary!
Solution: should import org.springframework.data.cassandra.repository.Query instead of org.springframework.data.jpa.repository.Query
```
