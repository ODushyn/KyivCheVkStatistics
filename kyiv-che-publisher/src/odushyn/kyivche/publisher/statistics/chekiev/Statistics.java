package odushyn.kyivche.publisher.statistics.chekiev;


import odushyn.kyivche.publisher.domain.message.Comment;
import odushyn.kyivche.publisher.domain.message.WallMessage;
import odushyn.kyivche.publisher.statistics.chekiev.domain.TripType;
import odushyn.kyivche.publisher.statistics.chekiev.domain.TripDirections;
import odushyn.kyivche.publisher.utils.VK;

import java.util.*;

/**
 * Created by Oleksander.Dushyn on 7/20/2015.
 */
public class Statistics {


    private final static String ROWS_COUNT = "50";
    private VK vk;
    private String groupName;
    private String groupId;

    public Statistics(VK vk, String groupName, String groupId) {
        this.vk = vk;
        this.groupName = groupName;
        this.groupId = groupId;
    }

    public void getMostActiveHitchhiker()  {

        List<WallMsgCheKyivWrapper> wallMessages = getWallMessages();

        Map<WallMsgCheKyivWrapper, List<Comment>> msgCommentMap = getComments(wallMessages);

        calculateMainParams(msgCommentMap);

        System.out.println("Success!!!");
    }

    public void getMostActiveDriver(){

    }

    private List<WallMsgCheKyivWrapper> getWallMessages(){
        List<WallMsgCheKyivWrapper> wrappedList = new ArrayList<WallMsgCheKyivWrapper>();
        Map<String, String> getWallMethodParams = new HashMap<String, String>();
        getWallMethodParams.put("domain", groupName);
        getWallMethodParams.put("count", ROWS_COUNT);

        for(WallMessage msg : vk.getWallMessages(getWallMethodParams)){
            wrappedList.add(new WallMsgCheKyivWrapper(msg));
        }

        return wrappedList;
    }

    private Map<WallMsgCheKyivWrapper, List<Comment>> getComments(List<WallMsgCheKyivWrapper> wallMessages){
        Map<WallMsgCheKyivWrapper, List<Comment>> msgCommentMap = new HashMap<WallMsgCheKyivWrapper, List<Comment>>();

        Map<String, String> getCommentParams = new HashMap<String, String>();
        getCommentParams.put("owner_id", groupId);
        getCommentParams.put("need_likes", "1");
        for(WallMsgCheKyivWrapper wrappedMsg : wallMessages){
            getCommentParams.put("post_id", wrappedMsg.getWallMessage().getId());
            msgCommentMap.put(wrappedMsg, vk.getComments(getCommentParams));
        }

        return msgCommentMap;
    }

    private StatisticParams calculateMainParams(Map<WallMsgCheKyivWrapper, List<Comment>> map){
        StatisticParams params = new StatisticParams();

        TripDirections tripDirection = createTrips(map);


        return params;
    }

    private TripDirections createTrips(Map<WallMsgCheKyivWrapper, List<Comment>> map){
        TripDirections trips = new TripDirections();

        for(Map.Entry<WallMsgCheKyivWrapper, List<Comment>> item: map.entrySet()){
            trips.addUsers(item.getKey(), item.getValue());
        }


        return trips;
    }

    private Date convertDate(String dateToConvert){
        String[] splitDate = dateToConvert.split("\\.");
        Calendar cal = Calendar.getInstance();
        cal.set(2015, Integer.valueOf(splitDate[1]), Integer.valueOf(splitDate[0]));

        return cal.getTime();
    }

}
