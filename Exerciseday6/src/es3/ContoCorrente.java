package es3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContoCorrente {
    private static Logger logger = LoggerFactory.getLogger(ContoCorrente.class);
    private final int maxMovimenti = 50;
    private String titolare;
    private int nMovimenti;
    private double saldo;

    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }

    public void preleva(double x) throws BancaException {
        if (nMovimenti < maxMovimenti) {
            saldo = saldo - x;
        } else {
            saldo = saldo - x - 0.50;
        }
        nMovimenti++;

        if (saldo < 0) {
            throw new BancaException("Il conto è in rosso");
        }
    }

    public double restituisciSaldo() {
        return saldo;
    }

    public String getTitolare() {
        return this.titolare;
    }
}