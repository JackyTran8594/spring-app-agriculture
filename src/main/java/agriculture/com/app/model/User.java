package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User")
public class User extends BaseModel {

    private String firstname;
    private String lastname;
    private String password;
    private String username;

    private String email;

    private String authorities;

    private String address;

    private String intro;

    @Column(name = "authorities")
    @Size(max = 100)
    public String getAuthorities() {
        return this.authorities;
    }

    @Column(name = "intro")
    @Size(max = 200)
    public String getIntro() {
        return this.intro;
    }

    @Column(name = "address")
    public String getAddress() {
        return this.address;
    }

    @Column(name = "username")
    @Size(max = 100)
    public String getUsername() {
        return this.username;
    }

    @Column(name = "password")
    public String getPassword() {
        return this.password;
    }

    @Column(name = "lastname")
    @Size(max = 100)
    public String getLastName() {
        return this.lastname;
    }

    @Column(name = "firstname")
    @Size(max = 100)
    public String getFirstName() {
        return this.firstname;
    }

    @Column(name = "email")
    @Size(max = 200)
    public String getEmail() {
        return this.email;
    }

    public User() {
    }

    public User(String firstname, String lastname, String email, String password, String username, String authorities) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.authorities = authorities;
    }

    // standard constructors / setters / getters / toString
}