package odushyn.kyivche.publisher.covertor;

import odushyn.kyivche.publisher.domain.BaseModel;
import org.json.simple.JSONArray;

import java.util.List;

/**
 * Created by Oleksander.Dushyn on 7/23/2015.
 */
public interface Convertor {

    List<? extends BaseModel> convert(JSONArray json);
}
