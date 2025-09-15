package es3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ContoCorrente conto1 = new ContoCorrente("Pinco Pallino", 5000.20);
        ContoOnLine conto2 = new ContoOnLine("Batman", 90000000.50, 50000);

        logger.info("--- Gestione Conto Corrente ---");
        try {
            conto1.preleva(600.0);
        } catch (BancaException e) {
            logger.error(e.getMessage());
        }

        logger.info("--- Gestione Conto OnLine ---");
        try {
            conto2.preleva(400000.0);
        } catch (BancaException e) {
            logger.error(e.getMessage());
        }

        try {
            System.out.println("Scegli un conto da cui prelevare (1 per ContoCorrente, 2 per ContoOnLine):");
            int sceltaConto = Integer.parseInt(scanner.nextLine());

            System.out.println("Inserisci l'importo da prelevare:");
            double importo = Double.parseDouble(scanner.nextLine());

            if (sceltaConto == 1) {
                conto1.preleva(importo);
                logger.info("Prelievo effettuato con successo dal conto 1. Nuovo saldo: " + conto1.restituisciSaldo());
            } else if (sceltaConto == 2) {
                conto2.preleva(importo);
                logger.info("Prelievo effettuato con successo dal conto 2. Nuovo saldo: " + conto2.restituisciSaldo());
            } else {
                logger.warn("Scelta non valida.");
            }
        } catch (NumberFormatException e) {
            logger.error("Input non valido. Inserisci solo numeri.");
        } catch (BancaException e) {
            logger.error("Errore di prelievo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
