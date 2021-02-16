<table width="100%">
    <tr>
        <td><a href="./006_Strings.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./010_Routing.md">Next</a></td>
    </tr>
</table>

#

#   @RestController and Annotations

In this tab, we will learn how to create controllers and go more in depth on annotations. Annotations are the small snippets of code that start with the `@`. For example, @RestController and @RequestMapping are some annotations that we have used previously. Create a brand new Spring Boot application named `controllerspractice`.

##  __Annotations and Hello World again!__
In HomeController.java, let's add similar code to what we did in the previous lesson.

### __HomeController.java__
```java
package com.codingdojo.controllerspractice.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
        @RequestMapping("/")
        public String hello() {
                return "Hello World!";
        }
}
```
Save it, restart your server and navigate to localhost:8080 in your browser. You should see "Hello World!" again.

Hint: There is a hotkey to import all your dependencies:

*   Windows: `Ctrl` + `shift` + `o`
*   Mac: `Command` + `shift` + `o`
### __Annotations__
In Java, annotations are a form of metadata that can be added to your source code. There are annotations for classes, methods, variables, parameters, and packages. Annotations are not Spring Boot specific, but part of the Java programming language. In our code above, we have two annotations. Let's go over each one:

1.  `@RestController` annotation: A convenient annotation that allows our controller to respond with data (ie. strings, json)
2.  `@RequestMapping` annotation: Annotation for mapping web requests onto specific handler classes (class level) and/or handler methods (method level). Currently in our code, we are using a method level annotation. Meaning that public String home() method will handle any request that comes to the "/" path. We can also annotate the whole class so that all methods respond to a certain path. For example: Now, the "/hello" route will respond with "Hello World!" and the "/hello/world" route will respond with "Class level annotations are cool too!"
```java
// ..
@RestController
@RequestMapping("/hello")
public class HomeController {
        @RequestMapping("")
        public String hello() {
                return "Hello World!";
        }
        @RequestMapping("/world")
        public String world() {
                return "Class level annotations are cool too!";
        }
}
```
### __Useful Links__
*   [RestController and RequestMapping example](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-first-application-code)
*   [RequestMapping documentation](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html)
*   [RestController documentation](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html)


#

[]()
<table width="100%">
    <tr>
        <td><a href="./006_Strings.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./010_Routing.md">Next</a></td>
    </tr>
</table>