# Read Me First
The following was discovered as part of building this project:

* The original package name 'Online Banking' is invalid and this project uses 'Online.Banking' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.0/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.0/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.0/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.0/reference/web/servlet.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.0/reference/using/devtools.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.


### TESTING 

1 UserController
### 1.register
Url: Request
http://localhost:8080/users/register?username=basha&password=basha123

Response :
{
"id": 4,
"username": "basha",
"password": "basha123"
}
### 2.login
url: Request
http://localhost:8080/users/login?username=basha&password=basha123

Response :
Login successful

2 AccountController

### 1. create 
url: Request
http://localhost:8080/accounts/create?userId=4

Response :
Account created successfully

### 2.balance
url: Request
http://localhost:8080/accounts/balance?userId=4

Response :
0.00

### 3.deposit
url :Request
http://localhost:8080/accounts/deposit?userId=4&amount=10000.0

Response :
Deposit successful.

### transfer
url :Request
http://localhost:8080/accounts/transfer?fromUserId=4&toUserId=2&amount=5000.0

Response :
Transfer successful





