package odushyn.kyivche.publisher.domain.message;

import odushyn.kyivche.publisher.domain.BaseModel;

import java.util.Date;

/**
 * Created by Oleksander.Dushyn on 7/23/2015.
 */
public class Comment extends BaseModel {

    private String id;
    private String hostId;
    private String text;
    private Date date;
    private String likesCount;
    private String ownerId;


    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(String likesCount) {
        this.likesCount = likesCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
