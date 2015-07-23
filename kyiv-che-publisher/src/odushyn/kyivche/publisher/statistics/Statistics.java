package odushyn.kyivche.publisher.statistics;

import odushyn.kyivche.publisher.domain.message.WallMessage;
import odushyn.kyivche.publisher.utils.VK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleksander.Dushyn on 7/20/2015.
 */
public class Statistics {

    private final static String ROWS_COUNT = "100";
    private VK vk;
    private String groupName;
    private String groupId;

    public Statistics(VK vk, String groupName, String groupId) {
        this.vk = vk;
        this.groupName = groupName;
        this.groupId = groupId;
    }

    public void getMostActiveHitchhiker()  {
        Map<String, String> getWallMethodParams = new HashMap<String, String>();
        getWallMethodParams.put("domain", groupName);
        getWallMethodParams.put("count", ROWS_COUNT);

        List<WallMessage> wallMessages = vk.getWallMessages(getWallMethodParams);

        Map<String, String> getCommentParams = new HashMap<String, String>();
        getCommentParams.put("owner_id", groupId);

        for(WallMessage wallMsg : wallMessages){
            getCommentParams.put("post_id", wallMsg.getId());
            vk.getComments(getCommentParams);
        }
    }

    public void getMostActiveDriver(){

    }

}
