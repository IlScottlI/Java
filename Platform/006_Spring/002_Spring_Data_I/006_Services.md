<table width="100%">
    <tr>
        <td><a href="./005_Respositories.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./007_Update_Delete.md">Next</a></td>
    </tr>
</table>

#

#   Services
Services are the business logic of our application. For example: a controller should never be doing something like creating 5 books. Imagine if we needed that same information in another controller; we would have to rewrite the same code again. Of course this would be a bad thing, we would be heavily violating the Don't Repeat Yourself (DRY) principle. In order to make sure we don't do that, we will create a service layer. We want skinny controllers and fat models (from MVC).

## __Our First Service__

Create a services package named `services` of `src/main/java/com/codingdojo/mvc`. In the said package, create a class named BookService. To declare a class to be a service, we use the @Service annotation. This annotation will allows Spring to inject this class as a dependency in any controller. Also, to access the database, we are going to need to use dependency injection for the repository.

### __src/main/java/com/codingdojo/mvc/services/BookService.java__
```java
// ...
import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.Book;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}
```
In our service, we created 3 methods. One to retrieve all the books, one to create a specific book, and one to retrieve a specific book. The `findById` method returns an optional object that may or may not contain our book object. We call the `isPresent()` method to check if our object exists. If it does, we return our book object by calling the get() method. If it does not, we return null.

##  __Setting up our API__

Now that we have domain models, repositories, and services, we can finally create our API to execute basic CRUD operations. Let's create a controller. To test our API, we will be using [Postman](https://www.getpostman.com/apps). It's simple to use but please make sure you watch the video to learn how to make requests.

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
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
}
```
The `private final BookService bookService` tells us that we are going to be using a `bookService` and that it will not be changing. Then, we use dependency injection to make it available in our controller. 

### __Important:__
Usually, APIs should respond with different error codes and appropriate error messages if something goes wrong. This exercise is to simply get us going with the complex MVC system of Spring. Once we implement our View, this will no longer be an issue.
### __Useful Links__
*   [Postman Download](https://www.getpostman.com/apps)
*   [Service annotation](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Service.html)
*   [Spring Boot Dependency Injection](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-spring-beans-and-dependency-injection.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./005_Respositories.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./007_Update_Delete.md">Next</a></td>
    </tr>
</table>