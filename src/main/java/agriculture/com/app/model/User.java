package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User extends BaseModel {

    private String firstname;
    private String lastname;
    private String password;
    private String username;

    private String email;

    private String authorities;

   

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

    @Column(name = "email")
    public String getEmail() {
        return email;
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