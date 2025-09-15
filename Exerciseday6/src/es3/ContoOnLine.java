package es3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContoOnLine extends ContoCorrente {
    private static Logger logger = LoggerFactory.getLogger(ContoOnLine.class);
    private double maxPrelievo;

    public ContoOnLine(String titolare, double saldo, double maxP) {
        super(titolare, saldo);
        this.maxPrelievo = maxP;
    }

    public void preleva(double x) throws BancaException {
        if (x <= maxPrelievo) {
            super.preleva(x);
        } else {
            throw new BancaException("Il prelievo non è disponibile");
        }
    }

    public void stampaSaldo() {
        logger.info("Titolare: " + super.getTitolare() + " - Saldo: " + super.restituisciSaldo() +
                " - Massimmo prelievo possibile: " + maxPrelievo);
    }
}