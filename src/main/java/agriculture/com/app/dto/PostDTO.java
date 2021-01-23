package agriculture.com.app.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class PostDTO {
    public String id;
    public String postId;
    public String content;
    public String title;
    public String note;
    public String author;
    public Integer numberOfLike;
    public Integer numberOfShare; 
    public Date dateCreated;

    public Date dateUpdated;

}
