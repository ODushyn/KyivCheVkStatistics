package odushyn.kyivche.publisher.statistics.chekiev.domain;

import odushyn.kyivche.publisher.domain.message.Comment;
import odushyn.kyivche.publisher.statistics.chekiev.WallMsgCheKyivWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 7/27/2015.
 */
public class TripDirections {

    private final static String KYIV = "Киев";
    private final static String CHE = "Чернигов";
    private List<TripType> cheKyiv = new ArrayList<TripType>();
    private List<TripType> kyivChe = new ArrayList<TripType>();

    public void addUsers(WallMsgCheKyivWrapper wallmsg, List<Comment> comments) {
        if(KYIV.equals(wallmsg.getFromCity())){
            this.kyivChe.add(new TripType(wallmsg.getType(), wallmsg.getDateOfTrip(), comments));
        }else if(CHE.equals(wallmsg.getFromCity())){
            this.cheKyiv.add(new TripType(wallmsg.getType(), wallmsg.getDateOfTrip(), comments));
        }
    }

    public List<TripType> getCheKyiv() {
        return cheKyiv;
    }

    public void setCheKyiv(List<TripType> cheKyiv) {
        this.cheKyiv = cheKyiv;
    }

    public List<TripType> getKyivChe() {
        return kyivChe;
    }

    public void setKyivChe(List<TripType> kyivChe) {
        this.kyivChe = kyivChe;
    }

}
