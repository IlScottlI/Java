<table width="100%">
    <tr>
        <td><a href="./../Index.md">Back</a></td>
        <td><a href="./../Index.md">Index</a></td>
        <td><a href="./002_MySQL_Plate.md">Next</a></td>
    </tr>
</table>


#   Basic Spring Boot Boilerplate

_NOTE: This Boilerplate does not have the dependencies for MySQL Data._  

1.  Copy `pom.xml` dependencies:


    ### __pom.xml__
    ```xml
    <dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.session</groupId>
			<artifactId>spring-session-core</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
        <!-- JSP Dependencies -->
		<dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
	    </dependency>
	    <dependency>
	            <groupId>javax.servlet</groupId>
	            <artifactId>jstl</artifactId>
	    </dependency>    
    </dependencies>
    ```

2.  Create the `src/main/webapp` folder.
3.  Create the `src/main/webapp/WEB-INF` folder.
4.  Edit the `src/main/resources/applications.properties` file to contain the following code:
    ```
    spring.mvc.view.prefix=/WEB-INF/
    ```
5.  Create `src/main/webapp/WEB-INF/index.jsp` file:
    ```js
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    ${message}
    ```
6.  Create IndexController `src/main/java/com.codingdojo.mvc.controllers/IndexController.java` class.
    ```java
    package com.codingdojo.mvc.controllers;

    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    public class IndexController {

        @RequestMapping("/")
        public String index(Model model) {
            model.addAttribute("message", "<h1>Hello World</h1>");
            return "index.jsp";
        }
    }
    ```
[]()
<table width="100%">
    <tr>
        <td><a href="./../Index.md">Back</a></td>
        <td><a href="./../Index.md">Index</a></td>
        <td><a href="./002_MySQL_Plate.md">Next</a></td>
    </tr>
</table>