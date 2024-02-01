import java.util.Random;

public class ValjPolylinje
{
    public static final Random rand = new Random();
    public static final int ANTAL_POLYLINJER = 10;

    public static void main(String[] args)
    {
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        for(int i = 0; i < ANTAL_POLYLINJER; i++)
        {
            polylinjer[i] = slumpPolylinje();
        }

        int shortestYellowLine = -1;
        double shortestYellowLineLength = 0.0;
        for(int i = 0; i < ANTAL_POLYLINJER; i++)
        {
            if(
                polylinjer[i].getFarg().equals("gul") &&
                polylinjer[i].langd() > shortestYellowLineLength
            ) {
                shortestYellowLine = i;
                shortestYellowLineLength = polylinjer[i].langd();
            }

            System.out.println(polylinjer[i]);
        }

        System.out.println("\nKortaste gula linjen:");
        if(shortestYellowLine >= 0)
        {
            System.out.print(polylinjer[shortestYellowLine] + "\nLängd: " + shortestYellowLineLength);
        }
        else
        {
            System.out.println("Det finns ingen gul linje.");
        }
    }

    public static Punkt slumpPunkt()
    {
        String n = "" + (char)(65 + rand.nextInt(26));
        int x = rand.nextInt(11);
        int y = rand.nextInt(11);

        return new Punkt(n, x, y);
    }

    public static Polylinje slumpPolylinje()
    {
        Polylinje linje = new Polylinje();

        int antalHorn = 2 + rand.nextInt(7);
        int antalValdaHorn = 0;
        boolean[] valdaNamn = new boolean[26];

        Punkt p = null;
        char n = 0;
        while(antalValdaHorn < antalHorn)
        {
            p = slumpPunkt();
            n = p.getNamn().charAt(0);

            if(!valdaNamn[(int)n - 65]) // Namnet har inte använts än.
            {
                linje.laggTill(p);
                antalValdaHorn += 1;
            }
        }

        switch(rand.nextInt(3))
        {
            case 0:
                linje.setFarg("blå");
                break;

            case 1:
                linje.setFarg("röd");
                break;

            case 2:
                linje.setFarg("gul");
                break;
                
        }

        return linje;
    }
}
