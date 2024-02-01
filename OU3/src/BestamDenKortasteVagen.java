public class BestamDenKortasteVagen
{
    // Avståndet mellan X och alla U
    private static double[] xu =
    {
        3, 1, 5
    };

    // Avståndet mellan alla U och V
    private static double[][] uv = 
    {
        { 6, 3, 8, 13 },    // U1 -> V1,2,3,4, U2 -> V1,2,3,4 osv
        { 17, 11, 7, 5 },
        { 1, 20, 1, 19 }
    };

    // Avståndet mellan alla V och Y
    private static double[] vy =
    {
        5, 1, 11, 4
    };

    public static void main(String[] args)
    {
        int[] mellanstationer = DenKortasteVagen.mellanstationer(xu, uv, vy);

        System.out.println("Kortaste vägen: " + DenKortasteVagen.langd(xu, uv, vy));
        System.out.println("Mellanstationer: X -> U" + mellanstationer[1] + " -> V" + mellanstationer[2] + " -> Y");
    }
}
