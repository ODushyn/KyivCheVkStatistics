package odushyn.kyivche.publisher.statistics.chekiev;

import odushyn.kyivche.publisher.statistics.chekiev.domain.CheKyiv;
import odushyn.kyivche.publisher.statistics.chekiev.domain.KyivChe;

/**
 * Created by Oleksander.Dushyn on 7/27/2015.
 */
public class StatisticParams {

    private CheKyiv cheKyiv;
    private KyivChe kyivChe;

    public CheKyiv getCheKyiv() {
        return cheKyiv;
    }

    public void setCheKyiv(CheKyiv cheKyiv) {
        this.cheKyiv = cheKyiv;
    }

    public KyivChe getKyivChe() {
        return kyivChe;
    }

    public void setKyivChe(KyivChe kyivChe) {
        this.kyivChe = kyivChe;
    }
}
