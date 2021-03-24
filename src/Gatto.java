import java.util.ArrayList;
import java.util.Scanner;

public class Gatto {
    String[] cosePerGatto = {"Cibo secco 5kg ", "Cibo secco 1kg ", "Cibo umido 500g ", "Cibo umido 80g ", "Frontline 3 pipette ", "Ciotola ", "Tiragraffi ", "Spazzola ", "Cesta "};
    double[] prezziProdotti = {30.00, 6.50, 4.50, 0.80, 19.00, 3.00, 8.00, 6.00, 12.00};
    int[] codiceCose = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public double mostraProdotti() { //non è static perché ho istanziato la classe cane  nel main
        System.out.println("****** Prodotti disponibili per il gatto ******");
        System.out.println();

        for (int i = 0; i < cosePerGatto.length; i++) {
            System.out.println(codiceCose[i] + ". " + cosePerGatto[i] + " - " + prezziProdotti[i] + " euro");
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

            int codice = in.nextInt() - 1;

            switch (codice) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8:

                    System.out.print("Immetti la quantita' di " + cosePerGatto[codice] + " da acquistare: ");
                    System.out.println();

                    int quantita = in.nextInt();
                    totaleParziale = quantita * prezziProdotti[codice];
                    totale += totaleParziale;
                    Carrello.add("Prodotto: " + cosePerGatto[codice] + "- " + " x" + quantita + " = " + totaleParziale + " euro");
                    System.out.print("Desidera altri prodotti (Y/N)?");
                    nuovoProdotto = in.next().toUpperCase();
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