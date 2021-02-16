<table width="100%">
    <tr>
        <td><a href="./012_Templating.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./014_Static_COntent.md">Next</a></td>
    </tr>
</table>

#

#       @Controllers and the View

##  __@Controller Instead of @RestController__
Like we mentioned before, we use the `@RestController` annotation to respond with data such as text or json. Now, we want to change direction and respond with a view. To do that, we must change the annotation from `@RestController` to `@Controller`. Let's change the code in our controller.

### __HomeController.java__
We are going to change our class to the `@Controller` annotation and our method for the root route.
```java
package com.codingdojo.controllerspractice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
}
```
Now, our index method is going to render the index.jsp file located in src/main/webapp/WEB-INF. Try it out yourself! Create a index.jsp file and add any jsp code.

##  __View Model__
Passing data to the view with Spring Boot is extremely easy. We pass data to our view using a `model` object. The model object implements the map interface and exposes the key-value pairs in our view. To pass data to our view can be as simple as injecting a `Model` object to our controller method:
```java
// ...
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("dojoName", "Burbank");
        return "index.jsp";
    }
// ...
```
and then calling that object in the view:

### __src/main/webapp/WEB-INF/index.jsp__
```
<c:out value="${dojoName}"/>
```
That's all you need to know to start passing data to your view!

### __Useful Links__
*   [About Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./012_Templating.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./014_Static_COntent.md">Next</a></td>
    </tr>
</table>