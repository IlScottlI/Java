<table width="100%">
    <tr>
        <td><a href="./004_Domain_Model.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./006_Services.md">Next</a></td>
    </tr>
</table>

#

#   Data Repository (Spring Data JPA)

Data repositories are where we gain access to all our data once we start talking with the database. What does that mean though?

To quote Eric Evans of Domain Driven Design: "A Repository represents all objects of a certain type as a conceptual set. It acts like a collection, except with more elaborate querying capability."

First, we need to create a new package: `src/main/java/com/codingdojo/mvc/repositories`. Then we need to make our `BookRepository` interface and extend the `CrudRepository`:

### __src/main/java/com/codingdojo/mvc/repositories/BookRepository.java__
```java
// ...
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
This will create a repository for us that will expose the Spring Data JPA. This will expose a variety of methods, as well as allow us to extend it. Without any further code, this will automatically allow us to create, read, update, and destroy our books; after all, it is a CRUD repository we are extending.

The Spring Data JPA Query creation can seem magical at first, and it takes some experience writing in it to get a good feel for the queries, but it will automatically build queries from method names in your interface. 

### __Useful Links:__
*   [Spring Data JPA docs](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)


#

[]()
<table width="100%">
    <tr>
        <td><a href="./004_Domain_Model.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./006_Services.md">Next</a></td>
    </tr>
</table>