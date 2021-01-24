package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "post_comment")
public class PostComment extends BaseModel {

    private String postId;
    private String content;
    private String title;
    private String note;
    private String parentId;
    private Boolean published;

    @Column(name = "postId")
    @Size(min = 10, max = 30)
    public String getPostId() {
        return this.postId;
    }

    @Column(name = "published")
    public Boolean getPublished() {
        return this.published;
    }

    @Column(name = "parentId")
    @Size(min = 10, max = 30)
    public String getParentId() {
        return this.parentId;
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

    public PostComment() {
    }

    public PostComment(String postId, String content, String title, String note, String parentId) {
        this.postId = postId;
        this.content = content;
        this.title = title;
        this.note = note;
        this.parentId = parentId;
    }

}
