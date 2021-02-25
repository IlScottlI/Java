<table width="100%">
    <tr>
        <td><a href="./005_BCrypt.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./007_Login_Logout.md">Next</a></td>
    </tr>
</table>

#

#   UserDetailsService
To authenticate and authorize a user, Spring Security needs an implementation of the UserDetailsService interface. In this lesson, we are going to create a custom class that implements said interface. Our class will be used to load the user according to the username that is passed from the form.

##  __UserDetailsServiceImplementation__
### __src/main/java/com/codingdojo/auth/services/UserDetailsServiceImplementation.java__
```JAVA
package com.codingdojo.auth.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.codingdojo.auth.models.Role;
import com.codingdojo.auth.models.User;
import com.codingdojo.auth.repositories.UserRepository;
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UserRepository userRepository;
    
    public UserDetailsServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    // 1
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
    }
    
    // 2
    private List<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}
```
The UserDetailsService only has one method that needs to be overwritten.

1.  loadUserByUserName(String username): Finds the user by their username. If a user is found, it returns it with the correct authorities. If the username does not exist, the method throws an error.
1.  getAuthorities(User user): returns a list of authorities/permissions for a specific user. For example, our clients can be 'user', 'admin', or both. For Spring Security to implement authorization, we must get the name of the possibles roles for current user from our database and create a new `SimpleGrantedAuthority' object with those roles.
## __Injecting the UserDetailsService__

### __src/main/java/com/codingdojo/auth/config/WebSecurityConfig.java__
```java
package com.codingdojo.auth.config;
// imports removed for brevity
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;
    
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
            authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/registration").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
    
    // 1
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }     
}

```
1.  configureGlobal(AuthenticationManagerBuilder): This method is configuring Spring Security to use our custom implementation of the `UserDetailsService` with Bcrypt.
### __Useful Links__
*   [UserDetailsService](https://docs.spring.io/spring-security/site/docs/3.2.7.RELEASE/apidocs/org/springframework/security/core/userdetails/UserDetailsService.html)
*   [GrantedAuthrority](http://docs.spring.io/spring-security/site/docs/current/apidocs/org/springframework/security/core/GrantedAuthority.html)
*   [Technical Guide to GrantedAuthority](https://docs.spring.io/spring-security/site/docs/3.0.x/reference/technical-overview.html#tech-granted-authority)
*   [SimpleGrantedAuthority](http://docs.spring.io/autorepo/docs/spring-security/3.2.1.RELEASE/apidocs/org/springframework/security/core/authority/SimpleGrantedAuthority.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./005_BCrypt.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./007_Login_Logout.md">Next</a></td>
    </tr>
</table>