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

To Run:
```
Make sure localhost:3306 is up
Run MicroserviceUserManagementApplication.java
Access http://localhost:8000/
Result: Redirect to service/user/
```

## II. Microservice Log Management
**Dependencies**
1. Spring Web Starter
2. Spring Data JPA
3. Rest Repositories
4. Spring Data Apache Cassandra
5. Eureka Discovery Client
6. Lombok

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

To Run:
```
Start Cassandra > cassandra.bat
Run MicroserviceLogManagementApplication.java
Access Access http://localhost:8002/
Will display:
{
  "_links" : {
    "logs" : {
      "href" : "http://localhost:8002/logs"
    },
    "summaries" : {
      "href" : "http://localhost:8002/summaries"
    },
    "profile" : {
      "href" : "http://localhost:8002/profile"
    }
  }
}
```


## III. Microservice Course Management
**Dependencies**
1. Spring Web Starter
2. Spring Data JPA
3. Rest Repositories
4. Liquibase Migration
5. MySQL Driver
6. Eureka Discovery Client
7. Lombok
8. OpenFeign

SQL vs HQL
- SQL works with table while HQL works with entity
- Hibernate Query Language (HQL) is an object-oriented query language, similar to SQL, but instead of operating on tables and columns, HQL works with persistent objects and their properties. HQL queries are translated by Hibernate into conventional SQL queries which in turns perform action on database. [Reference](https://www.quora.com/What-are-the-key-differences-between-SQL-Query-and-Hibernate-Query-Language-HQL)
- Structured Query Language, also popularly known as SQL, is a database language that uses the concept of relational database management to manage the data.  The managing of the data includes select (retrieves the data from a single or multiple tables), insert (adds one or more rows in a table), update (responsible for changing the value of one or more rows in a table), delete (responsible for deleting one or more rows in a table) and schema creation through queries. [Reference](http://www.differencebetween.net/technology/software-technology/difference-between-sql-and-hql/)

[OpenFeign/feign](https://github.com/OpenFeign/feign)
- Feign is a Java to HTTP client binder inspired by Retrofit, JAXRS-2.0, and WebSocket.

Allow origins for Cross-Origin Resource Sharing
- @Configuration WebConfig
- addCorsMapping

To Run:
```
Make sure localhost:3306 is up
Run MicroserviceCourseManagementApplication.java
Access http://localhost:8001/
Will display:
{
  "_links" : {
    "profile" : {
      "href" : "http://localhost:8001/profile"
    }
  }
}
```

## IV. Eureka Service
**Dependencies**
1. Eureka Server

To Run:
```
Run MicroserviceCourseManagementApplication.java
Access: http://localhost:8761/
Run user-service, log-service, course-service
Eureka should display:
COURSE-SERVICE	n/a (1)	(1)	UP (1) - xx:course-service:8001
LOG-SERVICE	n/a (1)	(1)	UP (1) - xx:log-service:8002
USER-SERVICE	n/a (1)	(1)	UP (1) - xx:user-service:8000
```
