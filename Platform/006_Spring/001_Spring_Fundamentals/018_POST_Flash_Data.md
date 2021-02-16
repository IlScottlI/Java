<table width="100%">
    <tr>
        <td><a href="./017_Counter.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./019_The_Code.md">Next</a></td>
    </tr>
</table>

#

#   POST requests and Flash Data
Now that you can use query strings, let's look at `POST` requests, and why you would want to use them. First imagine if we used query strings to pass our user and login information. That would mean that it would show up like this: `https://www.gmail.com?user=ninja&pass=SuperSecretPassword`. Would that be a good thing to leave in your browser history? (there are other, more technical reasons to use `POST` over `GET`, but you can look into those later).

Of course you would not want those in the browser history! Now meet `POST` requests, where you can submit a form without worry on leaving a trail of user information in the browser; instead it will include submitted information in the body of the request. As mentioned earlier, it's as easy as adding the `method` named argument to our `@RequestMapping` annotation:
```java
// ...
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login() {
// ...
```
Method      |       	Path	    |       Method
---         |       ---             |       ---
POST        |	/login	            |     HelloWorldController.login

Okay, that's nice and all, but how do we actually submit something? We just need to create a form and set POST as its method!
```html
<!-- ... -->
<form method="POST" action="/login">
    <label>Username: <input type="text" name="username"></label>
    <label>Password: <input type="password" name="password"></label>
    <button>Login</button>
</form>
<!-- ... -->
```
Okay, but we still have a problem. How do we get the information once it has been submitted? The exact same way that we grab information from the query string!
```java
// ...
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
// ...
```
It is really that easy. So once we have that information, what do we do with it? We process it, add whatever we want to save to our session and then redirect to a page to render the information.
```java
// ...
@Controller
public class UsersController {
      @RequestMapping(value="/login", method=RequestMethod.POST)
      public String login(@RequestParam(value="user") String user, @RequestParam(value="password") String password) {
            // ... process information and save it to the session
            return "redirect:/dashboard";
      }
// ...
```
```java
// ...
@Controller
public class DashboardController {
    @RequestMapping("/dashboard")
    public String dashboard() {
        // ... any code to process before rendering
        return "dashboard.jsp";
    }
// ...
```
##  __Flash Data__
Flash data is data that only persists across the next request. This sort of session data is very useful for things such as error messages, success notification, or anything else that you would want to show a user only immediately following their request.

###  __Using Flash Data__

To use our flash data we have to inject the `RedirectAttributes` into our method, and add flash attributes to it. For example, we might inject `RedirectAttributes` to our `createError` method to test sending an error back to our `index` method:
```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("dojoName", "Burbank");
        return "index.jsp";
    }
 
    @RequestMapping("/createError")
    public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "A test error!");
        return "redirect:/";
    }
}
```
In the above scenario, the only time that an error would be printed out is immediately following visiting `/createError`. This allows us to pass temporary data through our application to notify users across new request/response cycles.

### __Useful Links:__
*   [Request method definitions](https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html)
*   [Spring Boot Configuration notes](http://docs.spring.io/spring-boot/docs/1.5.3.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-auto-configuration)
*   [@RequestParam](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html)
*   [Spring MVC Flash](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-flash-attributes)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./017_Counter.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./019_The_Code.md">Next</a></td>
    </tr>
</table>