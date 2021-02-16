<table width="100%">
    <tr>
        <td><a href="./006_Services.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./008_Index.md">Next</a></td>
    </tr>
</table>

#

#   Update and Delete
In this assignment, you will be implementing the update and delete methods and test the endpoints with Postman. Continue using the same mvc project that we have been using so far. Here is some controller code to get you started.

### __src/main/java/com/codingdojo/mvc/controllers/BooksApi.java__
```java
// ..
import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;
@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    // other methods removed for brevity
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
```
Your task is to write the service methods that will correctly update and delete a book. To update a book, you will have to use the setter methods from the domain model and then call the `save` method. As you can see, `save` is used for both creating and updating. To delete a book, you will have to use the `deleteById` method. Below, I have linked to the `CrudRepository` documentation.

### __Useful Links__
*   [CrudRepository Methods](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./006_Services.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./008_Index.md">Next</a></td>
    </tr>
</table>