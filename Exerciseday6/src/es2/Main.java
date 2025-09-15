package es2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli un tipo di calcolo: 'int' o 'double'");
        String scelta = scanner.nextLine();

        try {
            if (scelta.equalsIgnoreCase("int")) {
                calcolaInt(scanner);
            } else if (scelta.equalsIgnoreCase("double")) {
                calcolaDouble(scanner);
            } else {
                logger.error("Scelta non valida. Riprova.");
            }
        } finally {
            scanner.close(); // Lo scanner viene chiuso una sola volta, alla fine.
        }
    }

    private static void calcolaInt(Scanner scanner) {
        try {
            System.out.println("--- Calcolo con INT ---");
            System.out.println("Quanti km hai fatto?");
            int km = Integer.parseInt(scanner.nextLine());

            System.out.println("Quanti litri di carburante hai usato?");
            int l = Integer.parseInt(scanner.nextLine());

            if (l == 0) {
                logger.error("Errore: I litri di carburante non possono essere zero.");
            } else {
                int rapportoKmL = km / l;
                logger.info("Hai consumato mediamente " + rapportoKmL + " km/l");
            }
        } catch (NumberFormatException e) {
            logger.error("Errore: Input non valido. Inserisci solo numeri interi.");
        }
    }

    private static void calcolaDouble(Scanner scanner) {
        try {
            System.out.println("--- Calcolo con DOUBLE ---");
            System.out.println("Quanti km hai fatto?");
            double km = Double.parseDouble(scanner.nextLine());

            System.out.println("Quanti litri di carburante hai usato?");
            double l = Double.parseDouble(scanner.nextLine());

            if (l == 0) {
                logger.error("Errore: I litri di carburante non possono essere zero.");
            } else {
                double rapportoKmL = km / l;
                logger.info("Hai consumato mediamente " + rapportoKmL + " km/l");
            }
        } catch (NumberFormatException e) {
            logger.error("Errore: Input non valido. Inserisci solo numeri.");
        }
    }
}