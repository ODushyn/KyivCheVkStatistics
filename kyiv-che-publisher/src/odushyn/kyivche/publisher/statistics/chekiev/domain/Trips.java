package odushyn.kyivche.publisher.statistics.chekiev.domain;

/**
 * Created by Oleksander.Dushyn on 7/27/2015.
 */
public class Trips {

    private TripDirection cheKyiv = new TripDirection();
    private TripDirection kyivChe = new TripDirection();

    public TripDirection getCheKyiv() {
        return cheKyiv;
    }

    public TripDirection getKyivChe() {
        return kyivChe;
    }
}
