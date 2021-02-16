<table width="100%">
    <tr>
        <td><a href="./008_Index.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./010_Show.md">Next</a></td>
    </tr>
</table>

#

#   New and Create
##  __New Book__
When the user visits "/books/new", we want to show them the form to create the book.

### __src/main/java/com/codingdojo/mvc/controllers/BooksController.java__
```JAVA
// ... imports removed for brevity
@Controller
public class BooksController {
    // other methods removed for brevity
    
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
}
```
### __Setting up the Form__
Here we see a new use of `@ModelAttribute`, we are not accessing data sent with the request, but rather instantiating a new Book type and binding to our view model. Since there is no `Book` being passed, an empty book will be instantiated and bound to our view model. Why would we want this though? The binding to our model will allow us to create a form that is also bound to the Book type, which will allow us to validate the information against our `Book` type!

### __Error Checking__
In the post request to create a book, we use the `@Valid` annotation to check to see if the submitted object passes validation. Once this is done, we can also inject the `BindingResult` to see if the object passed validation. __This must come immediately after the__ `@Valid` __parameter__. Once we have the `BindingResult` we can check if there were any errors, and then reload our form with errors if there are any.

### __src/main/webapp/WEB-INF/books/new.jsp__
```jsx
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<h1>New Book</h1>
<form:form action="/books" method="post" modelAttribute="book">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="language">Language</form:label>
        <form:errors path="language"/>
        <form:input path="language"/>
    </p>
    <p>
        <form:label path="numberOfPages">Pages</form:label>
        <form:errors path="numberOfPages"/>     
        <form:input type="number" path="numberOfPages"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
```
#

[]()
<table width="100%">
    <tr>
        <td><a href="./008_Index.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./010_Show.md">Next</a></td>
    </tr>
</table>