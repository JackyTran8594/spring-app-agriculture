package agriculture.com.app.dto;

import org.springframework.stereotype.Component;

@Component
public class LogInDTO {

    public String username;
    public String email;
    public String password;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
