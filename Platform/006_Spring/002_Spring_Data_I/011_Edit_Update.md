<table width="100%">
    <tr>
        <td><a href="./010_Show.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./012_Delete.md">Next</a></td>
    </tr>
</table>

#

#      Edit and Update
Similarly to New and Create, we are going to implement the Edit and Update features of our web application.

##  __Edit Book__
When the user visits "/books/1/edit", we want to show them a page with a form to edit the book with id 1.

### __src/main/java/com/codingdojo/mvc/controllers/BooksController.java__
```java
// ... imports removed for brevity
@Controller
public class BooksController {
    // other methods removed for brevity
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
}
```
Our update method will render the "/books/edit.jsp" view file if there are errors but redirect to "/books" if we are able to update the book successfully. Previously, we mentioned that you should never render on a POST request because of the double submission problem. However, when you have validations, the POST request will never be submitted unless the validation passes. Therefore, we would never double submit the request. Another reason to render on a POST request with validations is that we don't lose the information that the user has filled in the form. If we were to redirect, we would lose all the information in the form and the user would have to type everything again.

### __src/main/webapp/WEB-INF/books/edit.jsp___
```js
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<h1>Edit Book</h1>
<form:form action="/books/${book.id}" method="post" modelAttribute="book">
    <input type="hidden" name="_method" value="put">
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
Notice that we have added `<%@ page isErrorPage="true" %>` on top of the page. This will allow us to render this view on a PUT request.

### __src/main/resources/application.properties__
Finally, we will have to add an additional entry to our application.properties file:
<pre>
// other properties here (removed for brevity)
spring.mvc.hiddenmethod.filter.enabled=true
</pre>
#

[]()
<table width="100%">
    <tr>
        <td><a href="./010_Show.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./012_Delete.md">Next</a></td>
    </tr>
</table>