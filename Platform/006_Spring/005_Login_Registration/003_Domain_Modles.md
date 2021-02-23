<table width="100%">
    <tr>
        <td><a href="./002_Setup.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./004_Service_BCrypt.md">Next</a></td>
    </tr>
</table>

#

#   Domain Models and Repositories
For this application, we are going to create a simple `user` model. Create a schema named `authentication` in MySQL and update the `application.properties` file accordingly.
```
spring.datasource.url=jdbc:mysql://localhost:3306/authentication
spring.datasource.username=<<dbuser>>
spring.datasource.password=<<dbpassword>>
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

spring.mvc.view.prefix=/WEB-INF/
```
## __User Model__
In our application, our users will have a email, password and passwordConfirmation attributes. Note that we have the `@Transient` attribute for the passwordConfirmation member variable. This means that passwordConfirmation will not be saved in the database, and solely used for validation.

### __src/main/java/com/codingdojo/authentication/models/User.java__
```java
package com.codingdojo.authentication.models;
// imports removed for brevity
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @Transient
    private String passwordConfirmation;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    public User() {
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
##  __Repositories__
In the `UserRepository`, create a method that retrieves a specific user by their email.

###    __src/main/java/com/codingdojo/authentication/repositories/UserRepository.java__
```java
package com.codingdojo.authentication.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.authentication.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
```
#

[]()
<table width="100%">
    <tr>
        <td><a href="./002_Setup.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./004_Service_BCrypt.md">Next</a></td>
    </tr>
</table>