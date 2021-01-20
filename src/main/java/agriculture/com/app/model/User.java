package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User extends BaseModel {

    private final String firstname;
    private final String lastname;
    private final String password;
    private final String username;

    private final String email;

    private final String authorities;

    public User() {
        this.firstname = "";
        this.lastname = "";
        this.email = "";
        this.password = "";
        this.username = "";
        this.authorities = "";
    }

    @Column(name = "authorities")
    public String getAuthorities() {
        return authorities;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "lastname")
    public String getLastName() {
        return lastname;
    }

    @Column(name = "firstname")
    public String getFirstName() {
        return firstname;
    }

    public User(String firstname, String lastname, String email, String password, String username, String authorities) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.authorities = authorities;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    // standard constructors / setters / getters / toString
}