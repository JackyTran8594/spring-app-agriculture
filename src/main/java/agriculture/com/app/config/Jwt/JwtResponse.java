package agriculture.com.app.config.Jwt;

public class JwtResponse {
    public String token;
    public String type = "Bearer";
    public String email;
    public String username;
    public Long id;

    public JwtResponse(String token, String email, String username, Long id) {
        this.token = token;
        // this.type = type;
        this.email = email;
        this.username = username;
        this.id = id;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
