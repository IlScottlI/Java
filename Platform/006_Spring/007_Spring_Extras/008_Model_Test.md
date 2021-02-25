<table width="100%">
    <tr>
        <td><a href="./007_Testing_Model.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./../../007_Java_Spring_Deployment/001_AWS_EC2.md">Next</a></td>
    </tr>
</table>

#

#   Model Test
For this assignment, we will add an Author model to the previous assignment, and write the test to ensure our validations are working correctly.  The true nature of writing test is for them to be as specific as possible.  For this, we write out an individual test case for each field.  For example, in the Book example we used in the previous module, we could write the following test.
```java
@Test
void assumeTitleIsNull() {
    Book book = new Book();
    book.setDescription("Great Book");
    book.setLanguage("English");
    book.setNumberOfPages(734);
    Set<ConstraintViolation<book>> violations = validator.validate(book);
    assertFalse(violations.isEmpty());
}
```
This test will pass, because we tested to see that the violations `Set` would not be empty using `assertFalse`

#

[]()
<table width="100%">
    <tr>
        <td><a href="./007_Testing_Model.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./../../007_Java_Spring_Deployment/001_AWS_EC2.md">Next</a></td>
    </tr>
</table>