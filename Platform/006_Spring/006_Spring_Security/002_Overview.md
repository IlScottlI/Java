<table width="100%">
    <tr>
        <td><a href="./001_Auth.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./003_Data_Models.md">Next</a></td>
    </tr>
</table>

#

#   Spring Security Overview
Spring Security is a framework that provides authentication and authorization to Java applications. Some of its core features are:

*   Comprehensive and extensible support for both Authentication and Authorization
*   Protection against attacks like session fixation, clickjacking, cross-site request forgery (CSRF), etc
*   Servlet API integration
*   Spring MVC integration
  
We are going to be using Spring Security with our Spring Boot applications to implement a login and registration process for our application.

### __Set Up__
Create a brand new application named `auth` and add the following dependencies:

*   spring-boot-starter-jpa
*   spring-boot-starter-web
*   mysql-connector-java (runtime)
*   tomcat-embed-jasper
*   jstl
*   NEW: spring-boot-starter-security
This is how your dependencies in the pom.xml file should look like:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
</dependencies>
```
You should be familiar with all of these except for the `spring-boot-starter-security` dependency. This new dependency will allow us to use the Spring Security framework. In the next lesson, we will be setting up our Data Models and Repositories.

### __Useful Links__
*   [Spring Security](https://projects.spring.io/spring-security/)
*   [Spring Security Documentation](https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./001_Auth.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./003_Data_Models.md">Next</a></td>
    </tr>
</table>