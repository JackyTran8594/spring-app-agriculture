package agriculture.com.app.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
    public String id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String userName;

    // public UserDTO(long id, String firstName, String lastName, String email) {
    // this.id = id;
    // this.firstName = firstName;
    // this.lastName = lastName;
    // this.email = email;
    // };
}
