package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post extends BaseModel {
    
    private String postId;
    private String content;
    private String title;
    private String note;
    private String author;
    private Integer numberOfLike;
    private Integer numberOfShare;

    @Column(name="postId")
    public String getPostId() {
        return this.postId;
    }

    @Column(name="content")
    public String getContent() {
        return this.content;
    }

    @Column(name="title")
    public String getTitle() {
        return this.title;
    }

    @Column(name="note")
    public String getNote() {
        return this.note;
    }

    @Column(name="author")
    public String getAuthor() {
        return this.author;
    }

    @Column(name="like")
    public Integer getNumberOfLikeLike() {
        return this.numberOfLike;
    }

    @Column(name="share")
    public Integer getNumberOfShare() {
        return this.numberOfShare;
    }

    public Post() {
    }

    public Post(String postId, String content, String title, String note, String author, Integer numberOfLike, Integer numberOfShare) {
        this.postId = postId;
        this.content = content;
        this.title = title;
        this.note = note;
        this.author = author;
        this.numberOfLike = numberOfLike;
        this.numberOfShare = numberOfShare;
    }

    
}
