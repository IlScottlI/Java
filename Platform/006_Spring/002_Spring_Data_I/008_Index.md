<table width="100%">
    <tr>
        <td><a href="./007_Update_Delete.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./009_New_Create.md">Next</a></td>
    </tr>
</table>

#

#   Index
In the next few lessons, we will be implementing our views for our mvc application and change our controller code from an API to a full web application. Before you continue, make sure that you have installed the following dependencies: `tomcat-embed-jasper` and `jstl`. If you don't remember how to, here is the link to the [Spring Boot Templating](http://learn.codingdojo.com/m/103/5655/37374) lesson.

##  __All Books__
First, we will create another controller named `BooksController`. We will also create a view folder named `books` with a jsp file named `index.jsp`. When a user visits "/books", we want to show them all the books that we have in our database.
###  __src/main/java/com/codingdojo/mvc/controllers/BooksController.java__
```java
// ... imports removed for brevity
@Controller
public class BooksController {
    private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
}
```
### __src/main/webapp/WEB-INF/books/index.jsp__

```js
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1>All Books</h1>
<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.description}"/></td>
            <td><c:out value="${book.language}"/></td>
            <td><c:out value="${book.numberOfPages}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/books/new">New Book</a>
```


#

[]()
<table width="100%">
    <tr>
        <td><a href="./007_Update_Delete.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./009_New_Create.md">Next</a></td>
    </tr>
</table>