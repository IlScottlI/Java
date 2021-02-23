<table width="100%">
    <tr>
        <td><a href="./001_Basic_Plate.md">Back</a></td>
        <td><a href="./../Index.md">Index</a></td>
        <td><a href="">Next</a></td>
    </tr>
</table>

#   MySQL Spring Boot Boilerplate


1.  Copy `pom.xml` dependencies:


    ### __pom.xml__
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.session</groupId>
        <artifactId>spring-session-core</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency> 
    <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
    </dependency	>
    <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
    </dependency>
</dependencies>
```

2.  Create the `src/main/webapp` folder.
3.  Create the `src/main/webapp/WEB-INF` folder.
4.  Edit the `src/main/resources/applications.properties` file to contain the following code:
    ```
    spring.mvc.view.prefix=/WEB-INF/
    spring.datasource.url=jdbc:mysql://localhost:3307/spring-apps
    spring.datasource.username=root
    spring.datasource.password=root
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    ```
5.  Create `src/main/webapp/WEB-INF/index.jsp` file:
    ```js
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    ${message}
    ```
6.  Create IndexController `src/main/java/com.codingdojo.mvc.controllers/IndexController.java` class.
    ```java
    package com.codingdojo.mvc.controllers;

    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    public class IndexController {

        @RequestMapping("/")
        public String index(Model model) {
            model.addAttribute("message", "<h1>Hello World</h1>");
            return "index.jsp";
        }
    }
    ```
7.  Startup Spring Boot Server
8.  You may safely remove this setting from `src/main/resources/applications.properties`:
    ```
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    ```
9.  Create the following packages: 
    -   `models`
    -   `services`
    -   `repositories`
10. `src/main/java/com.codingdojo.mvc.models/Book.java`:
    ```java
    package com.codingdojo.mvc.models;

    import java.util.Date;

    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.PrePersist;
    import javax.persistence.PreUpdate;
    import javax.persistence.Table;
    import javax.validation.constraints.Min;
    import javax.validation.constraints.NotNull;
    import javax.validation.constraints.Size;

    import org.springframework.format.annotation.DateTimeFormat;
    @Entity
    @Table(name="books")
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotNull
        @Size(min = 1, max = 200)
        private String title;
        @NotNull
        @Size(min = 1, max = 200)
        private String description;
        @NotNull
        @Size(min = 1, max = 40)
        private String language;
        @NotNull
        @Min(1)
        private Integer numberOfPages;
        // This will not allow the createdAt column to be updated after creation
        @Column(updatable=false)
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date createdAt;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date updatedAt;
        
        public Book() {
        }
        public Book(String title, String desc, String lang, int pages) {
            this.title = title;
            this.description = desc;
            this.language = lang;
            this.numberOfPages = pages;
        }
        

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getLanguage() {
            return language;
        }
        public void setLanguage(String language) {
            this.language = language;
        }
        public Integer getNumberOfPages() {
            return numberOfPages;
        }
        public void setNumberOfPages(Integer numberOfPages) {
            this.numberOfPages = numberOfPages;
        }
        public Date getCreatedAt() {
            return createdAt;
        }
        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }
        public Date getUpdatedAt() {
            return updatedAt;
        }
        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }
        @PrePersist
        protected void onCreate(){
            this.createdAt = new Date();
        }
        @PreUpdate
        protected void onUpdate(){
            this.updatedAt = new Date();
        }
    }
    ```
11. `src/main/java/com/codingdojo/mvc/repositories/BookRepository.java`:
    ```java
    package com.codingdojo.mvc.models.repositories;

    import java.util.List;

    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;

    import com.codingdojo.mvc.models.Book;

    @Repository
    public interface BookRepository extends CrudRepository<Book, Long>{
        // this method retrieves all the books from the database
        List<Book> findAll();
        // this method finds books with descriptions containing the search string
        List<Book> findByDescriptionContaining(String search);
        // this method counts how many titles contain a certain string
        Long countByTitleContaining(String search);
        // this method deletes a book that starts with a specific title
        Long deleteByTitleStartingWith(String search);
    }
    ```
12. `src/main/java/com/codingdojo/mvc/services/BookService.java`:
    ```java
    package com.codingdojo.mvc.models.services;

    import java.util.List;
    import java.util.Optional;

    import org.springframework.stereotype.Service;

    import com.codingdojo.mvc.models.Book;
    import com.codingdojo.mvc.models.repositories.BookRepository;
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
        // retrieves a book and updates
        public Book updateBook(Book book) {
        return bookRepository.save(book);   
        }
        public void deleteBook(Long id) {
            bookRepository.deleteById(id);		
        }
    }
    ```
13. `src/main/java/com/codingdojo/mvc/controllers/BooksApi.java`
    ```java
    package com.codingdojo.mvc.controllers;

    import java.util.List;

    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    import com.codingdojo.mvc.models.Book;
    import com.codingdojo.mvc.models.services.BookService;
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
        public Book create(
                @RequestParam(value="title") String title, 
                @RequestParam(value="description") String desc, 
                @RequestParam(value="language") String lang, 
                @RequestParam(value="pages") Integer numOfPages
                ) {
            Book book = new Book(title, desc, lang, numOfPages);
            return bookService.createBook(book);
        }
        
        @RequestMapping("/api/books/{id}")
        public Book show(
                @PathVariable("id") Long id
                ) {
            Book book = bookService.findBook(id);
            return book;
        }
        
        @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
        public Book update(
                @PathVariable("id") Long id, 
                @RequestParam(value="title") String title, 
                @RequestParam(value="description") String desc, 
                @RequestParam(value="language") String lang, 
                @RequestParam(value="pages") Integer numOfPages
                ) {
            Book book = bookService.findBook(id);
            if(!book.equals(null)) {
                book.setTitle(title);
                book.setDescription(desc);
                book.setLanguage(lang);
                book.setNumberOfPages(numOfPages);
                bookService.updateBook(book);
            } 
            return book;
        }
        
        
        @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
        public void destroy(@PathVariable("id") Long id) {
            bookService.deleteBook(id);
        }
    }
    ```

14. `src/main/java/com/codingdojo/mvc/controllers/BooksController.java`;
    ```java
    package com.codingdojo.mvc.controllers;

    import java.util.List;

    import javax.validation.Valid;

    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;

    import com.codingdojo.mvc.models.Book;
    import com.codingdojo.mvc.models.services.BookService;

    @Controller
    public class BooksController {
        private final BookService bookService;
        public BooksController(BookService bookService){
            this.bookService = bookService;
        }
        
        @RequestMapping("/books/{id}/edit")
        public String edit(@PathVariable("id") Long id, Model model) {
            Book book = bookService.findBook(id);
            model.addAttribute("book", book);
            return "/books/edit.jsp";
        }
        
        @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
        public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
            if (result.hasErrors()) {
                return "/books/edit.jsp";
            } else {
                bookService.updateBook(book);
                return "redirect:/books";
            }
        }
        
        @RequestMapping("/books/new")
        public String newBook(@ModelAttribute("book") Book book) {
            return "/books/new.jsp";
        }
        
        @RequestMapping(value="/books", method=RequestMethod.POST)
        public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
            if (result.hasErrors()) {
                return "/books/new.jsp";
            } else {
                bookService.createBook(book);
                return "redirect:/books";
            }
        }
        
        @RequestMapping("/books")
        public String viewBooks(Model model) {
            List<Book> books = bookService.allBooks();
            model.addAttribute("books",books);
            return "/books/view.jsp";
        }
        
        @RequestMapping("/books/{id}")
        public String showBook(
                @PathVariable("id") Long id,
                Model model
                ){
            Book book = bookService.findBook(id);
            model.addAttribute("book", book);
            return "/books/show.jsp";
        }
        
        @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
        public String destroy(@PathVariable("id") Long id) {
            bookService.deleteBook(id);
            return "redirect:/books";
        }

    }
    ```
#

[]()
<table width="100%">
    <tr>
        <td><a href="./../Index.md">Back</a></td>
        <td><a href="./../Index.md">Index</a></td>
        <td><a href="">Next</a></td>
    </tr>
</table>