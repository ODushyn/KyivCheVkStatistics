package odushyn.kyivche.publisher.covertor;

import odushyn.kyivche.publisher.domain.BaseModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 7/23/2015.
 */
public abstract class Convertor {

    protected abstract List<? extends BaseModel> convert(JSONArray json);

/*    protected JSONArray getJSONObjectByKey(String key, JSONObject json){

        JSONParser parser   = new JSONParser();
        JSONObject jsonArray = null;
        try {
            JSONObject jsonResp  = (JSONObject) parser.parse(json);
            jsonArray = (JSONArray) jsonResp.get(key);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonArray;
    }*/

    protected Date convertDate(String unixTime){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.valueOf(unixTime)*1000);

        return calendar.getTime();
    }
}
