<table width="100%">
    <tr>
        <td><a href="./011_Edit_Update.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./013_Languages.md">Next</a></td>
    </tr>
</table>

#

#   Delete
We already created the delete button in the show page of each book. All we have to do is implement the destroy action in our controller.
```java
// ... imports removed for brevity
@Controller
public class BooksController {
    // other methods removed for brevity
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
        <td><a href="./011_Edit_Update.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./013_Languages.md">Next</a></td>
    </tr>
</table>