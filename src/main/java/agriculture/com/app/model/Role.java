package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String role;
    private String note;

    public Role() {
        this.role = "";
        this.note = "";
    }

    public Role(String role, String note, Integer id) {
        this.role = role;
        this.note = note;
        this.id = id;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    @Column(name = "note")
    public String getNote() {
        return note;
    }

    @Column(name = "id")
    public Integer getId() {
        return id;
    }

}