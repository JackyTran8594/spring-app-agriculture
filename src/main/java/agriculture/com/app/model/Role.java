package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "role")
public class Role extends BaseModel {

    private String roleId;
    private String role;
    private String note;

    public Role() {

    }

    public Role(String role, String note, String roleId) {
        this.role = role;
        this.note = note;
        this.roleId = roleId;
    }

    @Column(name = "role")
    @Size(max = 50)
    public String getRole() {
        return this.role;
    }

    @Column(name = "note")
    @Size(max = 500)
    public String getNote() {
        return this.note;
    }

    @Column(name = "roleId")
    @Size(min = 10, max = 30)
    public String getRoleId() {
        return this.roleId;
    }

}