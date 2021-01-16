package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends BaseModel {

    private String roleId;
    private String role;
    private String note;

    public Role() {
        this.role = "";
        this.note = "";
        this.roleId = "";
    }

    public Role(String role, String note, String roleId) {
        this.role = role;
        this.note = note;
        this.roleId = roleId;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    @Column(name = "note")
    public String getNote() {
        return note;
    }

    @Column(name = "roleId")
    public String getRoleId() {
        return roleId;
    }

}