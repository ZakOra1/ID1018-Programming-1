import java.util.*;

public class EnTriangelOchDessCirklar {

    public static void main(String[] args) {
        //inmatningsverktyg
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        //Visuell representation av triangel
        System.out.println("        / \\");
        System.out.println("       /   \\");
        System.out.println("  a   /     \\   c");
        System.out.println("     /       \\");
        System.out.println("    /_________\\");
        System.out.println("        b");

        //inmatning av värden
        System.out.print("a = ");
        double a = in.nextDouble();
        System.out.print("b = ");
        double b = in.nextDouble();
        System.out.print("c = ");
        double c = in.nextDouble();

        //Omskrivna cirkeln
        double oc_radie = Triangel.Omskrivna_cirkeln(a,b,c);
        System.out.println("Omskrivna cirkelns radie: " + oc_radie);

        //Inskrivna cirkeln
        double in_radie = Triangel.Inskrivna_cirkeln(a,b,c);
        System.out.println("Inskrivna cirkelns radie: " + in_radie);
    }
}
