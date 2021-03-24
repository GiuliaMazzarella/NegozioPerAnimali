import java.util.ArrayList;
import java.util.Scanner;

public class Cane {
    String[] cosePerCane = {"Cibo secco 5kg ", "Cibo secco 1kg ", "Cibo umido 500g ", "Cibo umido 80g ", "Frontline 4 pipette ", "Ciotola ", "Gioco per pulizia denti ", "Guinzaglio con collare ", "Cuccia "};
    double[] prezziProdotti = {33.00, 7.50, 4.00, 1.00, 18.50, 3.00, 4.00, 8.00, 99.00};
    int[] codiceCose = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public double mostraProdotti() { //non è static perché ho istanziato la classe cane  nel main
        System.out.println("****** Prodotti disponibili per il cane ******\n");

        for (int i = 0; i < cosePerCane.length; i++) {
            System.out.println(codiceCose[i] + ". " + cosePerCane[i] + " - " + prezziProdotti[i] + " euro");
        }

        System.out.println();
        double totale = cassa();

        return totale;
    }

    public double cassa() {
        boolean ancora = true;
        double totaleParziale, totale = 0.0;
        String nuovoProdotto = "";
        Scanner in = new Scanner(System.in);

        ArrayList<String> Carrello = new ArrayList<String>();

        do {
            System.out.print("Per favore, digitare il codice in base al prodotto scelto: ");

            int codice = in.nextInt() - 1; //-1 perché mi allineo all'indice dell'array cosePerCane, quindi 1 corrisponde a 0. Quindi 1-1=0

            switch (codice) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8:

                    System.out.print("Immettere la quantita' di " + " - " + cosePerCane[codice] + " - da acquistare: \n");

                    int quantita = in.nextInt();
                    totaleParziale = quantita * prezziProdotti[codice];
                    totale += totaleParziale;
                    Carrello.add("Prodotto: " + cosePerCane[codice] + " x" + quantita + " = " + totaleParziale + " euro");
                    System.out.print("Desidera altri prodotti (Y/N)? ");
                    nuovoProdotto = in.next().toUpperCase(); //in.next
                    System.out.println();
                    break;
                default:
                    System.out.println("Codice non contemplato");
            }

            if (!nuovoProdotto.equals("Y")) { //stringhe non sono un tipo primitivo - equals è un metodo relativo all'uguagliare le stringhe
                ancora = false;
            }

        } while (ancora);

        System.out.println();
        System.out.println("****** Articoli nel carrello ******");

        for (String lettore : Carrello) {
            System.out.println(lettore);
        }

        return totale;
    }
}