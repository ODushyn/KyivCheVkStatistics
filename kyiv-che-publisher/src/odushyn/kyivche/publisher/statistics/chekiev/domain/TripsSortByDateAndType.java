package odushyn.kyivche.publisher.statistics.chekiev.domain;

import java.util.Calendar;
import java.util.Comparator;

/**
 * Created by Oleksander.Dushyn on 7/27/2015.
 */
public class TripsSortByDateAndType implements Comparator<TripType> {

    @Override
    public int compare(TripType t1, TripType t2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(t1.getDateOfTrip());
        int day1 = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(t2.getDateOfTrip());
        int day2 = cal.get(Calendar.DAY_OF_MONTH);
        
        if(day1 - day2 > 0){
            return 1;
        }else if(day1 - day2 < 0){
            return -1;
        }
        if(t1.getUserType() == UserType.HITCHHIKER){
            return 1;
        }else if(t1.getUserType() == UserType.DRIVERS){
            return -1;
        }
        return 0;
    }
}
