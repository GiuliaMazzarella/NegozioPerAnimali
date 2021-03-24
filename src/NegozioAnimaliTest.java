import java.util.Locale;
import java.util.Scanner;

public class NegozioAnimaliTest {
    public static void main(String args[]) {
        double totaleSpesa = 0.0;
        boolean ancora = true;
        Scanner in = new Scanner(System.in);
        System.out.println("******Benvenuti in ANIMALHOUSE******\n");

        do {
            System.out.print("Vuole acquistare per un cane (C) o un gatto (G)? \n");

            String animale = in.nextLine().toUpperCase();

            switch (animale) {
                case "C":
                    Cane mioCane = new Cane();
                    totaleSpesa += mioCane.mostraProdotti();
                    break;
                case "G":
                    Gatto mioGatto = new Gatto();
                    totaleSpesa += mioGatto.mostraProdotti();
                    break;
                default:
                    System.out.println("Ci scusiamo per l'inconveniente, ma ancora non vendiamo nulla per questo genere di animale oppure la sua digitazione e' errata! Scelga o cane o gatto!");
            }

            System.out.print("Vuole fare altri acquisti? (Y/N) ");
            String nuovoAcquisto = in.nextLine().toUpperCase();

            if (!nuovoAcquisto.equals("Y")) {
                ancora = false;
                //SE IO PREMO NO PERCHE VOGLIO PER UN ALTRO ANIMALE CHE NON C'E' MI DA' UNO SCONTRINO VUOTO CHE NON VORREI
            }

        } while (ancora);

        System.out.println();
        System.out.println("******Scontrino fiscale******\n");
        System.out.println("Totale: " + totaleSpesa + " euro\n");
        System.out.println("Grazie e arrivederci! (:");
    }
}
