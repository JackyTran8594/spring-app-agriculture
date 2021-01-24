package agriculture.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "category")
public class Category extends BaseModel {

    private String parentId;
    private String title;
    private String metaTitle;
    private String note;
    private String slug;
    private String content;

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

    public Category() {
    }

    public Category(String parentId, String title, String metaTitle, String note, String slug, String content) {
        this.parentId = parentId;
        this.title = title;
        this.metaTitle = metaTitle;
        this.note = note;
        this.slug = slug;
        this.content = content;
    }

}
