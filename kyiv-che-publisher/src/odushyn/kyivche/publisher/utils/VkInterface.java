package odushyn.kyivche.publisher.utils;

import odushyn.kyivche.publisher.domain.message.WallMessage;

import java.util.List;
import java.util.Map;

/**
 * Created by Oleksander.Dushyn on 7/23/2015.
 */
public interface VkInterface {

    List<WallMessage> getWallMessages(Map<String, String> paramsMap);
}
