package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post extends BaseModel {

    private String postId;
    private String context;
    private Long like;
    private Long share;
    private String note;

    @Column(name = "context")
    public String getContext() {
        return context;
    }

    @Column(name = "like")
    public Long getLike() {
        return like;
    }

    @Column(name = "share")
    public Long getShare() {
        return share;
    }

    public Post() {
    }

    @Column(name = "note")
    public String getNote() {
        return note;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    private String author;

    public Post(String postId, String context, Long like, Long share, String note, String author) {
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
