package odushyn.kyivche.publisher.statistics;

import odushyn.kyivche.publisher.domain.message.Comment;
import odushyn.kyivche.publisher.domain.message.WallMessage;
import odushyn.kyivche.publisher.utils.VK;

import java.util.ArrayList;
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

        List<WallMsgCheKievWrapper> wallMessages = getWallMessages();

        Map<WallMsgCheKievWrapper, List<Comment>> msgCommentMap = getComments(wallMessages);

        System.out.println("Success!!!");
    }

    public void getMostActiveDriver(){

    }

    private List<WallMsgCheKievWrapper> getWallMessages(){
        List<WallMsgCheKievWrapper> wrappedList = new ArrayList<WallMsgCheKievWrapper>();
        Map<String, String> getWallMethodParams = new HashMap<String, String>();
        getWallMethodParams.put("domain", groupName);
        getWallMethodParams.put("count", ROWS_COUNT);

        for(WallMessage msg : vk.getWallMessages(getWallMethodParams)){
            wrappedList.add(new WallMsgCheKievWrapper(msg));
        }

        return wrappedList;
    }

    private Map<WallMsgCheKievWrapper, List<Comment>> getComments(List<WallMsgCheKievWrapper> wallMessages){
        Map<WallMsgCheKievWrapper, List<Comment>> msgCommentMap = new HashMap<WallMsgCheKievWrapper, List<Comment>>();

        Map<String, String> getCommentParams = new HashMap<String, String>();
        getCommentParams.put("owner_id", groupId);
        getCommentParams.put("need_likes", "1");
        for(WallMsgCheKievWrapper wrappedMsg : wallMessages){
            getCommentParams.put("post_id", wrappedMsg.getWallMessage().getId());
            msgCommentMap.put(wrappedMsg, vk.getComments(getCommentParams));
        }

        return msgCommentMap;
    }

    private StatisticParams calculateMainParams(){
        StatisticParams params = new StatisticParams();

        return params;
    }

}
