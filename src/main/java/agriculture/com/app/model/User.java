package agriculture.com.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "User")
public class User extends BaseModel {
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private Long id;
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

    // @Column(name = "id")
    // public Long getId() {
    // return id;
    // }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    // @Override
    // public String toString() {
    // return "User{" + "id=" + id + ", name=" + firstname + " " + lastname + ",
    // email=" + email + '}';
    // }
    // standard constructors / setters / getters / toString
}