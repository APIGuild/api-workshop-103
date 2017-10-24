# api-workshop-103

### Json web token (JWT)
#### Requirement
Enable JWT Authentication

```java
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(HEADER_STRING);
        if (!hasText(token)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return ;
        }

        //TODO: implement simple jwt validation
        chain.doFilter(request, response);

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getRequestURI().contains("jwt");
    }
}
```

#### Postman

http://localhost:8080/login

body
 raw JSON/(application/json)
 ```json
     {
     	"username": "your name",
     	"password": "your password"
     }
 ```
http://localhost:8080/jwt/greeting

header
Authorization Bearer "your token"