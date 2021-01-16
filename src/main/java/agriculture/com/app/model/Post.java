package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post extends BaseModel {
    private String postId;
    private String context;
    private Integer like;
    private Integer share;
    private String note;

    @Column(name = "context")
    public String getContext() {
        return this.context;
    }

    @Column(name = "like")
    public Integer getLike() {
        return this.like;
    }

    @Column(name = "share")
    public Integer getShare() {
        return this.share;
    }

    public Post() {
    }

    @Column(name = "note")
    public String getNote() {
        return this.note;
    }

    @Column(name = "author")
    public String getAuthor() {
        return this.author;
    }

    private String author;

    public Post(String postId, String context, Integer like, Integer share, String note, String author) {
        this.postId = postId;
        this.context = context;
        this.like = like;
        this.share = share;
        this.note = note;
        this.author = author;
    }

    @Column(name = "postId")
    public String getPostId() {
        return postId;
    }

}
