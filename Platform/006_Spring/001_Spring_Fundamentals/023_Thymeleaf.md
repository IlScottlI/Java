<table width="100%">
    <tr>
        <td><a href="./022_Dependency_Injection.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./../002_Spring_Data_I/001_Models.md">Next</a></td>
    </tr>
</table>

#

#   Thymeleaf
One of the popular templating libraries for Spring Boot is Thymeleaf; a Java library with the goal of providing an elegant and well-formed way of creating HTML 5 templates.

### __Set up:__
```html
<dependency>
    <groupid>org.springframework.boot</groupid>             
    <artifactid>spring-boot-starter-thymeleaf</artifactid>
</dependency>
```
Once you have that dependency added, you can start using the Thymeleaf engine to serve up files from the templates folder in your Spring Boot project. Make sure you do not have any JSP dependencies active for this. You will not need any JSP or Tomcat dependencies.

Try serving up two files:

### __/src/main/resources/templates/twofour.html__
```html
<p th:text="${2+4}"></p>
```
and

### __/src/main/resources/templates/twotwo.html__
```html
<p data-th-text="${2+2}"></p>
```
To serve these you do not need to edit any properties files, you only need to return the name from your routes:

### __/src/main/java/dashboard.java__
```java
// ...
public class Dashboard {
    @RequestMapping("/")
    public String index() {
        return "twofour";
    }
} 
```
All data being passed to your view will work the same as your JSP views, unless you used HttpSession instead of `@SessionAttributes`.

### __th: or data-th?__
Why are there two ways to do it? It all boils down to one very simple answer: `data-th` is HTML5 compatible, `th:` is not. Use `th:` for anything that doesn't need to be HTML5 compatible, and `data-th` for HTML5 compatible pages.

### __Standard Expression Syntax__
If Thymeleaf interests you, explore the [Standard Expression Syntax](http://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#standard-expression-syntax) and try re-doing some of the assignments.

#

[]()
<table width="100%">
    <tr>
        <td><a href="./022_Dependency_Injection.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./../002_Spring_Data_I/001_Models.md">Next</a></td>
    </tr>
</table>