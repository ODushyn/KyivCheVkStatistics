package odushyn.kyivche.publisher.statistics.chekiev.domain;

import odushyn.kyivche.publisher.domain.message.Comment;
import odushyn.kyivche.publisher.statistics.chekiev.WallMsgCheKyivWrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 7/27/2015.
 */
public class TripDirection {

    private Date dateOfTrip;
    private List<Comment> hitchihiker =  new ArrayList<Comment>();
    private List<Comment> drivers =  new ArrayList<Comment>();

    public void addDriver(Comment driver){
        this.drivers.add(driver);
    }

    public void addHitchihiker(Comment hitchhiker){
        this.hitchihiker.add(hitchhiker);
    }

    public Date getDateOfTrip() {
        return dateOfTrip;
    }

    public void setDateOfTrip(Date dateOfTrip) {
        this.dateOfTrip = dateOfTrip;
    }

    public List<Comment> getHitchihiker() {
        return hitchihiker;
    }

    public void setHitchihiker(List<Comment> hitchihiker) {
        this.hitchihiker = hitchihiker;
    }

    public List<Comment> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Comment> drivers) {
        this.drivers = drivers;
    }
}
