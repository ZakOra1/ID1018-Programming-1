public class PolylinjeTest
{
    public static void main(String[] args)
    {
        Punkt[] punkter =
        {
            new Punkt("A", 0, 0),
            new Punkt("B", 1, 2),
            new Punkt("C", 5, 8)
        };

        Polylinje linje = new Polylinje(punkter);
        System.out.println(linje);
        System.out.println("Längd: " + linje.langd());
        System.out.println();

        linje.laggTill(new Punkt("E", 10, 10));
        System.out.println(linje);
        System.out.println("Längd: " + linje.langd());
        System.out.println();

        linje.laggTillFramfor(new Punkt("D", 7, 7), "E");
        System.out.println(linje);
        System.out.println("Längd: " + linje.langd());
        System.out.println();

        linje.taBort("E");
        System.out.println(linje);
        System.out.println("Längd: " + linje.langd());
        System.out.println();

        // Testa iterator
        Polylinje.PolylinjeIterator iterator = linje.new PolylinjeIterator();
        while(iterator.finnsHorn())
        {
            try
            {
                System.out.println(iterator.horn());
            }
            catch(java.util.NoSuchElementException e)
            {
                System.out.println(e.getMessage());
            }

            iterator.gaFram();
        }
    }
}
