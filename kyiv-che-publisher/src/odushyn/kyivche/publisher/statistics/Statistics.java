package odushyn.kyivche.publisher.statistics;

import odushyn.kyivche.publisher.utils.VK;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oleksander.Dushyn on 7/20/2015.
 */
public class Statistics {

    private VK vk;
    private String groupName;

    public Statistics(VK vk, String groupName) {
        this.vk = vk;
        this.groupName = groupName;
    }

    public void getMostActiveHitchhiker()  {
        Map<String, String> wallMethodParams = new HashMap<String, String>();
        wallMethodParams.put("domain", groupName);
        wallMethodParams.put("copy_history_depth", "2");

        vk.getWallMessages(wallMethodParams);
    }

    public void getMostActiveDriver(){

    }

}
