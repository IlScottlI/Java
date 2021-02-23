<table width="100%">
    <tr>
        <td><a href="./003_Student_Roster_1.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./005_Dojos_and_Ninjas.md">Next</a></td>
    </tr>
</table>

#

# Relationships Continued
In this tab, we will learn how to create One-to-Many relationships
## __1:n__
We are going to create a 1:n relationship between a dojo and many ninjas

<img src="./../../000_img/onetoone%20(1).png">

### __models/Dojo.java__
```java
// ...
@Entity
@Table(name="dojos")
public class Dojo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;
    
    public Dojo() {
        
    }
    // ...
    // getters and setters removed for brevity
    // ...
}
```
### __models/Ninja.java__
```java
// ..
@Entity
@Table(name="ninjas")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
    
    public Ninja() {
        
    }
    // ...
    // getters and setters removed for brevity
    // ...
}
```
## __New Annotations Used__
*   `@OneToMany`: Defines a many-valued association with one-to-many multiplicity. This may be used within an embeddable class contained within an entity class to specify a relationship to a collection of entities. Notice that in this case, our ninjas attribute is of type `List<Ninja>`.
    *   `@OneToMany(mappedBy="dojo")`: This will map the ninjas attribute in the Dojo class to the dojo attribute in the Ninja class.
    *   There are a few other options that you can have. We encourage you to visit the useful link for the One-to-Many relationship.
*   `@ManyToOne`: Defines a single-valued association to another entity class that has many-to-one multiplicity. This may be used within an embeddable class to specify a relationship from the embeddable class to an entity class. Notice that our dojo attribute is referring to the dojo_id. Therefore, this attribute gives the dojo that a specific ninja belongs to.

*   `@JoinColumn(name="dojo_id")`: Defines mapping for composite foreign keys. It indicates that the corresponding table to this entity has a foreign_key to the referenced table.

### __Useful Links__
*   [One-to-Many](http://www.objectdb.com/api/java/jpa/OneToMany)
*   [Many-to-One](http://www.objectdb.com/api/java/jpa/ManyToOne)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./003_Student_Roster_1.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./005_Dojos_and_Ninjas.md">Next</a></td>
    </tr>
</table>