package odushyn.kyivche.publisher.statistics.chekiev;

import odushyn.kyivche.publisher.domain.message.WallMessage;

/**
 * Created by Oleksander.Dushyn on 7/27/2015.
 */
public class WallMsgCheKievWrapper{

    private String dateOfTrip;
    private String type;
    private String fromCity;
    private String toCity;
    private WallMessage wallMessage;

    public WallMsgCheKievWrapper(WallMessage wallMessage) {
        this.wallMessage = wallMessage;
        String[] text = wallMessage.getText().split(" ");
        if(text.length < 5){
            return;
        }
        this.dateOfTrip = text[0];
        this.type = text[1];
        this.fromCity = text[2];
        this.toCity = text[4];
    }

    public String getDateOfTrip() {
        return dateOfTrip;
    }

    public void setDateOfTrip(String dateOfTrip) {
        this.dateOfTrip = dateOfTrip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public WallMessage getWallMessage() {
        return wallMessage;
    }

    public void setWallMessage(WallMessage wallMessage) {
        this.wallMessage = wallMessage;
    }
}
