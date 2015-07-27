package odushyn.kyivche.publisher.covertor;

import odushyn.kyivche.publisher.domain.message.Comment;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 7/23/2015.
 */
public class CommentConvertor extends Convertor {

    @Override
    public List<Comment> convert(JSONArray json) {
        if(json == null){
            return null;
        }

        List<Comment> list = new ArrayList<Comment>();

        for (int i=1; i < json.size(); i++) {
            JSONObject jsonObject = (JSONObject) json.get(i);

            Comment msg = new Comment();
            msg.setHostId(jsonObject.get("from_id").toString());
            msg.setText(jsonObject.get("text").toString());
            msg.setId(jsonObject.get("cid").toString());

            JSONObject likes = (JSONObject) jsonObject.get("likes");
            msg.setLikesCount(likes.get("count").toString());

            msg.setDate(convertDate(jsonObject.get("date").toString()));

            list.add(msg);
        }

        return list;
    }
}
