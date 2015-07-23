package odushyn.kyivche.publisher.covertor;

import odushyn.kyivche.publisher.domain.BaseModel;
import odushyn.kyivche.publisher.domain.message.WallComment;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 7/23/2015.
 */
public class WallCommentConvertor implements Convertor {

    @Override
    public List<WallComment> convert(JSONArray json) {
        List<WallComment> list = new ArrayList<WallComment>();

        for (int i=1; i < json.size(); i++) {
            JSONObject jsonObject = (JSONObject) json.get(i);

            /*WallComment msg = new WallComment();
            msg.setId(jsonObject.get("id").toString());
            msg.setText(jsonObject.get("text").toString());
            msg.setLikes(jsonObject.get("likes").toString());

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.valueOf(jsonObject.get("date").toString()));
            msg.setPostDate(calendar.getTime());

            if(jsonObject.get("copy_owner_id") != null) {
                msg.setOwnerId(jsonObject.get("copy_owner_id").toString());
            }*/

            //list.add(msg);
        }

        return list;
    }
}
