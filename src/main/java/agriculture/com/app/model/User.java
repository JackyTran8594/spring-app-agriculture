package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String userName;

    private final String email;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.userName = "";

    }

    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public User(String first_name, String last_name, String email, String password, String userName) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.email = email;
        this.password = password;
        this.userName = userName;

    }

    @Column(name = "id")
    public long getId() {
        return id;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + firstName + " " + lastName + ", email=" + email + '}';
    }
    // standard constructors / setters / getters / toString
}