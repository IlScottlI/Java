<table width="100%">
    <tr>
        <td><a href="./008_Routing.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./010_Routing.md">Next</a></td>
    </tr>
</table>

#

#   Query Parameters and URL Parameters

If you make a request to `http://www.bing.com/search?q=what+are+query+parameters` or `http://www.google.com/search?q=query+parameters` from your browser, you'll see that Bing and Google will be able to use that data and fill in your search bar. You've just used query parameters to send a server information. Everything after the ? will be sent to the server as query parameter key value pairs (everything after the `?` is called the query string or the URI parameters). In this case you sent Google this:

Field (key)	|   Value
--- |   ---
q	|   query parameters

To implement query parameters, all we need to do is use the @RequestParam annotation in our methods. We could include the parameter "searchQuery" as a type String (request parameters must always be of String type) and annotate it as a URL query field of "q":
```java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
    @RequestMapping("/")
    public String index(@RequestParam(value="q") String searchQuery) {
        return "You searched for: " + searchQuery;
    }
}
```
While this will work, if you try to access your endpoint without a query parameter, your application will crash. This is due to another argument for the` @RequestParam` annotation, `required`, defaulting to `true`. If we want to allow our users to submit we can set `required=false` in our annotation call...
```java
    @RequestMapping("/")
    public String index(@RequestParam(value="q", required=false) String searchQuery) {
        return "You searched for: " + searchQuery;
    }
//...
```
#
URL Parameters (Path Variables)

One of the other primary ways for you to transmit information to the server is by the URL parameters. Consider this route `http://learn.codingdojo.com/m/59/5436/33349`. Each path variable plays a role to find the exact resource that needs to be displayed to the client.

With Spring Boot we are able to implement something very similar easily. We will be using the @PathVariable annotation:
```java
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
    @RequestMapping("/m/{track}/{module}/{lesson}")
    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
    }
}
```
### __Useful Links:__
*   [@RequestParam](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html)
*   [Type conversion for query Parameters](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-typeconversion)
*   [Path variable docs](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PathVariable.html)
*   [Spring MVC](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./008_Routing.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./010_Routing.md">Next</a></td>
    </tr>
</table>