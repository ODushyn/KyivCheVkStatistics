package odushyn.kyivche.publisher.domain.message;

import odushyn.kyivche.publisher.domain.BaseModel;

import java.util.Date;

/**
 * Created by Oleksander.Dushyn on 7/23/2015.
 */
public class WallMessage extends BaseModel {

    private String id;
    private String ownerId;
    private String text;
    private Date postDate;
    private String likes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
