package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "post_meta")
public class PostMeta extends BaseModel {

    private String postId;
    private String title;
    private String keyMeta;
    private String note;
    private String content;

    @Column(name = "postId")
    @Size(min = 10, max = 30)
    public String getParentId() {
        return this.postId;
    }

    @Column(name = "postId")
    @Size(max = 50)
    public String getKeyMeta() {
        return this.keyMeta;
    }

    @Column(name = "content")
    public String getContent() {
        return this.content;
    }

    @Column(name = "title")
    @Size(max = 200)
    public String getTitle() {
        return this.title;
    }

    @Size(max = 500)
    @Column(name = "note")
    public String getNote() {
        return this.note;
    }

    public PostMeta() {
    }

    public PostMeta(String title, String note, String content, String keyMeta) {
        this.title = title;
        this.note = note;
        this.content = content;
        this.keyMeta = keyMeta;
    }

}
