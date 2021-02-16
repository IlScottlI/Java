<table width="100%">
    <tr>
        <td><a href="./003_MySQL.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./005_Respositories.md">Next</a></td>
    </tr>
</table>

#

#   Domain Model and Validation Annotations

In this tab, we will learn how to create domain models and services. Our "domain models" will contain the structure, or model, of the objects we are dealing with, and the services will contain all the logic for manipulating them.

You also need to include spring-boot-starter-validations as of June 2020.
```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>   
```
##  __Domain Model__
The domain model is simply a Java Bean that represents our "business data," or the information that we want about a particular thing. In this case, we will create a model class for a book resource. In `src/main/java/com/codingdojo/mvc`, create a new package called `models`. Inside said package, create a new class named `Book`. Since this class must be a Java Bean, it must have private attributes, getter and setters in the getField() and setField() formats, and an empty constructor.

### __src/main/java/com/codingdojo/mvc/models/Book.java__
```java
package com.codingdojo.mvc.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 200)
    private String title;
    @NotNull
    @Size(min = 5, max = 200)
    private String description;
    @NotNull
    @Size(min = 3, max = 40)
    private String language;
    @NotNull
    @Min(100)
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
    
    // other getters and setters removed for brevity
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
Once we refresh our spring application, a table named `books` should have been created for us in our `book-schema`.

##  __Validation Annotations__
The annotations do almost exactly what they say:

*   `@Entity`: represents an entity model for our application
*   `@Table`: sets this as a table in the database
*   `@Id`: sets this as the primary key
*   `@GeneratedValue`: sets this as an auto-incrementing value
*   `@Size` adds validation that the column must be in the specified range
*   `@Min` adds validation that the column must be at least the specified value
*   `@NotNull` adds validation that the column must be null
*   `@PrePersist` runs the method right before the object is created
*   `@PreUpdate` runs a method when the object is modified

#

[]()
<table width="100%">
    <tr>
        <td><a href="./003_MySQL.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./005_Respositories.md">Next</a></td>
    </tr>
</table>