package agriculture.com.app.dto;

import org.springframework.stereotype.Component;

@Component
public class LogInDTO {

    public String userName;
    public String email;
    public String password;

    public String getUsername() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
