package agriculture.com.app.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class RoleDTO {
    public String id;
    public String roleId;
    public String role;
    public String note;
    public Date dateCreated;
    public Date dateUpdated;
}
