package odushyn.kyivche.publisher.covertor;

import odushyn.kyivche.publisher.domain.BaseModel;
import odushyn.kyivche.publisher.domain.message.WallMessage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 7/23/2015.
 */
public class WallMessageConvertor extends Convertor {

    @Override
    public List<WallMessage> convert(JSONArray json) {
        if(json == null){
            return null;
        }

        List<WallMessage> list = new ArrayList<WallMessage>();

        for (int i=1; i < json.size(); i++) {
            JSONObject jsonObject = (JSONObject) json.get(i);

            WallMessage msg = new WallMessage();
            msg.setId(jsonObject.get("id").toString());
            msg.setText(jsonObject.get("text").toString());
            msg.setLikes(jsonObject.get("likes").toString());

            msg.setPostDate(convertDate(jsonObject.get("date").toString()));

            if(jsonObject.get("copy_owner_id") != null) {
                msg.setOwnerId(jsonObject.get("copy_owner_id").toString());
            }

            list.add(msg);
        }

        return list;
    }
}
