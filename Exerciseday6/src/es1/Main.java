package es1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Random random = new Random();
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10) + 1;
        }
        logger.info("Array iniziale " + Arrays.toString(arr));

        Scanner scanner = new Scanner(System.in);
        int numero = -1;

        do {
            try {
                System.out.println("Inserisci un numero. Se vuoi uscire premi 0");
                numero = Integer.parseInt(scanner.nextLine());

                if (numero == 0) {
                    break;
                }

                int posizione = -1;
                do {


                    System.out.println("Inserisci la posizione da modificare da 0 a 4");
                    try {
                        posizione = Integer.parseInt(scanner.nextLine());


                        if (posizione < 0 || posizione >= arr.length) {
                            logger.error("Errore, la posizione non è valida");
                            posizione = -1;
                        }
                    } catch (NumberFormatException e) {
                        logger.error("Errore: input non valido. Inserisci solo numeri per la posizione.");
                        posizione = -1;
                    }
                } while (posizione == -1);


                arr[posizione] = numero;
                logger.info("Nuovo array " + Arrays.toString(arr));


            } catch (NumberFormatException e) {
                logger.error("Errore, input non valido. Inserisci solo numeri.");
            }
        }
        while (true);
        scanner.close();
        logger.info("Terminato");
    }


}
