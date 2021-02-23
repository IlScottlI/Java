<table width="100%">
    <tr>
        <td><a href="">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="">Next</a></td>
    </tr>
</table>

#

#   Validations


Validations are extremely important for any web application. By implementing validations, we ensure database integrity and only save valid and important information in our data store. The simplest way to add validations is through persistent models annotations. If you need a reminder, re-visit our lesson back in [Persistence Model Annotations](./../002_Spring_Data_I/002_JPA.md)

##  __Validations with Annotation__
We are going to add validations for the size of the username and password with custom messages

### __src/main/java/com/codingdojo/authentication/models/User.java__
```java
package com.codingdojo.authentication.models;
import javax.validation.constraints.class="entity class from-rainbow">Size;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
// other imports removed for brevity
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue()
    private Long id;
    // NEW
    @Email(message="Email must be valid")
    private String email;
    // NEW
    @Size(min=5, message="Password must be greater than 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    // rest of the model removed for brevity
}
```
Great! We have some validations but not all. What about making sure that the password and password confirmation fields match? Enter custom validations.

##  __Custom Validations__
Spring provides a Validator interface for custom validations. Create a new package named `validator` and create a UserValidator class. The `Validator` interface comes from the `org.springframework.validation.Validator`.

### __src/main/java/com/codingdojo/authentication/validator/UserValidator.java__
```java
package com.codingdojo.authentication.validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.codingdojo.authentication.models.User;
@Component
public class UserValidator implements Validator {
    
    // 1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}
```
1.   `supports(Class<?>)`: Specifies that a instance of the User Domain Model can be validated with this custom validator
2.  `validate(Object, Errors)`: Creating our custom validation. We can add errors via .rejectValue(String, String).
3.  `.rejectValue(String, String)`: the first argument is the member variable of our Domain model that we are validating. The second argument is a code for us to use to set an error message.
4.  `@Component`. Below is an explanation of this annotating from the Spring Documentation.

    Spring provides further stereotype annotations: `@Component`, `@Service`, and `@Controller`. `@Component` is a generic stereotype for any Spring-managed component. `@Repository`, `@Service`, and `@Controller` are specializations of `@Component` for more specific use cases, for example, in the persistence, service, and presentation layers, respectively. Therefore, you can annotate your component classes with `@Component`, but by annotating them with `@Repository`, `@Service`, or `@Controller` instead, your classes are more properly suited for processing by tools or associating with aspects.
##  __Even More Custom Messages__
To set custom errors messages, we must create a `messages.properties` file inside of `src/main/resources`

### __src/main/resources/messages.properties__
```
Match.user.passwordConfirmation=Password and Password Confirmation must match
```
The format of our error messages is __CODE.ModelAttribute.MemberVariable=YOUR CUSTOM ERROR MESSAGE__

Now, in our `POST` request for '/registration', we must use the Validator.

### __src/main/java/com/codingdojo/authentication/controllers/Users.java__
```java
@Controller
public class Users {
    private final UserService userService;
    
    // NEW
    private final UserValidator userValidator;
    
    // NEW
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
        
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "registrationPage.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/home";
    }
    
    // code removed for brevity
}
```
Make sure to give your application a hard reset to see the validations working.

### __Useful Links__
*   [Validations](http://docs.spring.io/autorepo/docs/spring/3.2.x/spring-framework-reference/html/validation.html)
*   [@Component Doc](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-stereotype-annotations)

#

[]()
<table width="100%">
    <tr>
        <td><a href="">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="">Next</a></td>
    </tr>
</table>