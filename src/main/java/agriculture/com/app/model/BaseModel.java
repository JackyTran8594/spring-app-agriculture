package agriculture.com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass()
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dateCreated;

    private Date dateUpdated;

    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "dateUpdated")
    public Date getDateUpdated() {
        return dateUpdated;
    }

    @Column(name = "dateCreated")
    public Date getDateCreated() {
        return dateCreated;
    }

}
