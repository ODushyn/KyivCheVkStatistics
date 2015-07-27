package odushyn.kyivche.publisher.statistics.chekiev;


import odushyn.kyivche.publisher.domain.message.Comment;
import odushyn.kyivche.publisher.domain.message.WallMessage;
import odushyn.kyivche.publisher.statistics.chekiev.domain.Trips;
import odushyn.kyivche.publisher.utils.VK;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Oleksander.Dushyn on 7/20/2015.
 */
public class Statistics {

    private final static String KYIV = "Киев";
    private final static String CHE = "Чернигов";
    private final static String HITCHHIKER = "Попутчики";
    private final static String DRIVERS = "Подвезу";
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

        Trips trips = createTrips(map);


        return params;
    }

    private Trips createTrips(Map<WallMsgCheKyivWrapper, List<Comment>> map){
        Trips trips = new Trips();

        for(Map.Entry<WallMsgCheKyivWrapper, List<Comment>> item: map.entrySet()){

            if(KYIV.equals(item.getKey().getFromCity())){
                if(DRIVERS.equals(item.getKey().getType())) {
                    trips.getKyivChe().setDrivers(item.getValue());
                }else if(HITCHHIKER.equals(item.getKey().getType())) {
                    trips.getKyivChe().setHitchihiker(item.getValue());
                }
                trips.getKyivChe().setDateOfTrip(convertDate(item.getKey().getDateOfTrip()));
            }else{
                if(CHE.equals(item.getKey().getFromCity())){
                    if(DRIVERS.equals(item.getKey().getType())) {
                        trips.getCheKyiv().setDrivers(item.getValue());
                    }else if(HITCHHIKER.equals(item.getKey().getType())) {
                        trips.getCheKyiv().setHitchihiker(item.getValue());
                    }
                    trips.getCheKyiv().setDateOfTrip(convertDate(item.getKey().getDateOfTrip()));

                }
            }
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
