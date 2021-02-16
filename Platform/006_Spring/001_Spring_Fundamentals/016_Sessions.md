<table width="100%">
    <tr>
        <td><a href="./015_Display_Date.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./017_Counter.md">Next</a></td>
    </tr>
</table>

#

#   Session Access in Spring Boot
You already know how to access and manipulate the session! You can use the same `HttpSession` object that you used to persist information across your servlet and JSP web app! You simply need to put it into your method params:
```java
    //...
    public String index(HttpSession session){
        session.setAttribute("count", 0);
        Integer count = (Integer) session.getAttribute("count");
    }
    // ...
```
and use it as you have used HttpSession objects previously!

### __Useful Links:__
*   [HttpSession](http://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpSession.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./015_Display_Date.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./017_Counter.md">Next</a></td>
    </tr>
</table>