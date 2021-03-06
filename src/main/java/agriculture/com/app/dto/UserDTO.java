package agriculture.com.app.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
    public String id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String userName;
    public Date dateCreated;

    public Date dateUpdated;

}
