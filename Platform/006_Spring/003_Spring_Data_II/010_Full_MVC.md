<table width="100%">
    <tr>
        <td><a href="./009_Student_Roster_III.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./011_DojoOverflow.md">Next</a></td>
    </tr>
</table>

#

#   MVC Review with Spring Boot
Let's revisit the MVC picture that we introduced in the very first lesson on Spring Boot.

<img src="./../../000_img/mvc-response-cycle%20(1).png">

By now, you should have a good grasp on all the moving parts that allow us to build web applications with Spring.

### __Incoming Request__
The DispatcherServlet (Front Controller) analyzes the incoming request and dispatches it to the appropriate controller. It uses handlers to delegate the request. Annotations such as @Controller and @RequestMapping allow the Front Controller to correctly hand off the request.

### __Creating the Model__
The Controller's job is to handle the request, interpret user input and transform it into a model. Depending on the request, the controller may have to talk to a service to retrieve, insert, update or delete some information from the database. Once this process is done, a model is returned to our controller.

### __View Template__
The View template is reponsible for rendering what the client sees by using the model object. Once that process is done, everything is returned to the Front Controller to package it as a response.

### __Useful Links__
*   [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./009_Student_Roster_III.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./011_DojoOverflow.md">Next</a></td>
    </tr>
</table>