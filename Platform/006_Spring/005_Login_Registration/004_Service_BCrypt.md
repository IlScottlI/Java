<table width="100%">
    <tr>
        <td><a href="./003_Domain_Modles.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./005_Controllers.md">Next</a></td>
    </tr>
</table>

#

#   Service and BCrypt
We already installed the BCrypt dependency. The only thing we have to do now is to write our methods to register and authenticate users. Since this is the business logic of our application, the code should live in the `service`.

### __src/main/java/com/codingdojo/authentication/services/UserService.java__
```java
package com.codingdojo.authentication.services;
import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepository;
@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
```
That's it! Super simple. Next, we will be implementing the controller and the views.

#

[]()
<table width="100%">
    <tr>
        <td><a href="./003_Domain_Modles.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./005_Controllers.md">Next</a></td>
    </tr>
</table>