import java.util.*; // Scanner, Locale

class Temperaturer
{
    public static void main (String[] args)
    {
        System.out.println("TEMPERATURER\n");

        // inmatningsverktyg
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        // mata in uppgifter om antalet veckor och antalet mätningar
        System.out.print("antalet veckor: ");
        int antalVeckor = in.nextInt();
        System.out.print("antalet mätningar per vecka: ");
        int antalMatningarPerVecka = in.nextInt();

        // plats att lagra temperaturer
        double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

        // mata in temperaturerna
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            System.out.println("temperaturer - vecka " + vecka + ":");
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                t[vecka][matning] = in.nextDouble();
        }
        System.out.println();

        // visa temperaturerna
        System.out.println("temperaturerna:");
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                System.out.print (t[vecka][matning] + " ");
            System.out.println();
        }
        System.out.println();

        // den minsta, den största och medeltemperaturen – veckovis
        double[] minT = new double[antalVeckor + 1];
        double[] maxT = new double[antalVeckor + 1];
        double[] sumT = new double[antalVeckor + 1];
        double[] medelT = new double[antalVeckor + 1];

        // koden ska skrivas här
        //hittar minsta, största och medeltemperaturen för varje vecka och skriver ut dem
        for(int vecka = 1; vecka <= antalVeckor; vecka++)
		{
		     for(int dag = 1; dag <= antalMatningarPerVecka; dag++)
		     {
		        if(dag == 1) {
		            minT[vecka] = t[vecka][dag];
		            maxT[vecka] = t[vecka][dag];
		        }
		     	else if(t[vecka][dag] < minT[vecka]){
		     	    minT[vecka] = t[vecka][dag];
		     	}
		     	else if(t[vecka][dag] > maxT[vecka]) {
		     	    maxT[vecka] = t[vecka][dag];
		     	}
		     	sumT[vecka] += t[vecka][dag];
		     }
		     medelT[vecka] = sumT[vecka]/antalMatningarPerVecka;
		     System.out.println("-------------------------------------");
		     System.out.println("Temperatur for vecka " + vecka + ":");
		     System.out.println("* Lagsta temperaturen: "+ minT[vecka]);
		     System.out.println("* Hogsta temperaturen: "+ maxT[vecka]);
		     System.out.println("* Medel temperaturen: "+ medelT[vecka]);
        }
        // koden ska skrivas här

        // den minsta, den största och medeltemperaturen - hela mätperioden
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double medelTemp = 0;

        // koden ska skrivas här
        // visa den minsta, den största och medeltemperaturen i hela mätperioden
        for(int vecka = 1; vecka <= antalVeckor; vecka++)
        {
			if(minTemp > minT[vecka]) {
				minTemp = minT[vecka];
			}
			else if(maxTemp < maxT[vecka]) {
				maxTemp = maxT[vecka];
			}
	    }
	    medelTemp = (minTemp + maxTemp)/2;
        System.out.println("----------------------------------------------");
        System.out.println("Temperatur for hela matperioden");
        System.out.println("* Lagsta temp: "+ minTemp);
        System.out.println("* Hogsta temp: "+ maxTemp);
        System.out.println("* Medel temp: "+ medelTemp);
        // koden ska skrivas här

    }
}
