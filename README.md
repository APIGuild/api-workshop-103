# api-workshop-103

### BASIC AUTH
* cd project folder and run "./gradlew cleanIdea idea"
* run "idea ."
* create package "config"
* create class WebSecurityConfig
```java
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().regexMatchers("security/greeting").fullyAuthenticated();
        http.csrf().disable();
        http.httpBasic();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                    .inMemoryAuthentication()
                    .withUser("user").password("password");
    }
}
```


