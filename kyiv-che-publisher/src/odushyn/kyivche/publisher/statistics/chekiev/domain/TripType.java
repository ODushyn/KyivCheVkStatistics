package odushyn.kyivche.publisher.statistics.chekiev.domain;

import odushyn.kyivche.publisher.domain.message.Comment;
import odushyn.kyivche.publisher.statistics.chekiev.WallMsgCheKyivWrapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 7/27/2015.
 */
public class TripType {

    private final static String HITCHHIKER = "Попутчики";
    private final static String DRIVERS = "Подвезу";
    private Date dateOfTrip;
    private UserType userType;
    private List<Comment> users =  new ArrayList<Comment>();


    public TripType(String type, String date, List<Comment> comments) {
        if(HITCHHIKER.equals(type)){
            this.userType = UserType.HITCHHIKER;
        }else if(DRIVERS.equals(type)){
            this.userType = UserType.DRIVERS;
        }
        this.users = comments;
        this.dateOfTrip = convertDate(date);
    }

    private Date convertDate(String dateToConvert){
        String[] splitDate = dateToConvert.split("\\.");
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), Integer.valueOf(splitDate[1]) - 1, Integer.valueOf(splitDate[0]));

        return cal.getTime();
    }

    public Date getDateOfTrip() {
        return dateOfTrip;
    }

    public UserType getUserType() {
        return userType;
    }

    public List<Comment> getUsers() {
        return users;
    }
}
