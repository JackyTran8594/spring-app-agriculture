package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "post")
public class Post extends BaseModel {

    private String postId;
    private String content;
    private String title;
    private String metaTitle;
    private String note;
    private String authorId;
    private Integer numberOfLike;
    private Integer numberOfShare;
    private String slug;
    private String summary;

    @Column(name = "postId")
    @Size(min = 10, max = 30)
    public String getPostId() {
        return this.postId;
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

    @Column(name = "authorId")
    @Size(min = 10, max = 30)
    public String getAuthor() {
        return this.authorId;
    }

    @Column(name = "like")
    public Integer getNumberOfLikeLike() {
        return this.numberOfLike;
    }

    @Column(name = "share")
    public Integer getNumberOfShare() {
        return this.numberOfShare;
    }

    @Column(name = "metaTitle")
    @Size(max = 200)
    public String getMetaTitle() {
        return this.metaTitle;
    }

    @Column(name = "slug")
    @Size(max = 100)
    public String getSlug() {
        return this.slug;
    }

    @Column(name = "summary")
    @Size(max = 200)
    public String getSummary() {
        return this.summary;
    }

    public Post() {
    }

    public Post(String postId, String content, String title, String note, String authorId, Integer numberOfLike,
            Integer numberOfShare, String metaTitle, String slug, String summary) {
        this.postId = postId;
        this.content = content;
        this.title = title;
        this.note = note;
        this.authorId = authorId;
        this.numberOfLike = numberOfLike;
        this.numberOfShare = numberOfShare;
        this.metaTitle = metaTitle;
        this.slug = slug;
        this.summary = summary;
    }

}
