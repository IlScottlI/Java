<table width="100%">
    <tr>
        <td><a href="./007_RestController.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./009_Parameters.md">Next</a></td>
    </tr>
</table>

#

#   Routing
Every request will be organized based on two parts: the path and the request method. The request method is easy to identify: it is `get` unless you have specified it otherwise, e.g. as a `post` request in a form. The path is easiest to identify visually by example:

URL |	Path
---------   |   ----------
https://en.wikipedia.org/wiki/URL   |	/wiki/URL

### __Spring Boot__
Let's look at a hypothetical Controller and map out some routes.
```java
// ...
@RestController
public class HomeController {
    @RequestMapping("/greeting")
    public String index(){
      return "Hello user!";
    }
    // you can be explicit about the request as well
    @RequestMapping(value="/greeting/hello", method=RequestMethod.GET)
    public String hello(){
      return "Hello world! What route did you use to access me?";
    }
    @RequestMapping("/greeting/goodbye")
    public String world(){
      return "Goodbye world!";
    }
}
```
This would be mapped as follows:

Method  |	Path                |	Method
--------|-----------------------|-----------------------
GET     |	/greeting           |	HomeController.index
GET     |	/greeting/hello	    |   HomeController.hello
GET	    |   /greeting/goodbye   |	HomeController.world

If it felt tedious to write "/greeting" over and over, then you're thinking like a programmer. With Spring you can annotate the entire class, so the code equivalent to the above would be:
```java
// ...
@RestController
@RequestMapping("/greeting")
public class HomeController {
    @RequestMapping("")
    public String index(){
      return "This is accessed view http://your_server/simple/root";
    }
    @RequestMapping("/hello")
    public String hello(){
      return "Hello world! What route did you use to access me?";
    }
    @RequestMapping("/goodbye")
    public String world(){
      return "Goodbye world!";
    }
}
```
This maps to the exact same table above.

### __Useful Links:__
*   [HTTP Request Methods](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods)
*   [Request Mapping](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html)
*   [Request Method](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMethod.html)


#

[]()
<table width="100%">
    <tr>
        <td><a href="./007_RestController.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./009_Parameters.md">Next</a></td>
    </tr>
</table>