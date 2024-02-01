public class DenKortasteVagen
{
    public static int[] mellanstationer(double[] a, double[][] b, double[] c)
    {
        int[] result = new int[3];

        double shortDist = 0.0;
        boolean firstLoop = true;

        // Loopia igenom alla möjliga vägar och räkna ut den totala längden på vägen.
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < b[i].length; j++)
            {
                double dist = a[i] + b[i][j] + c[j];

                // Ifall det är första gången vi kommer hit
                // måste vi ange det första avståndet som den
                // kortaste vägen; Gör vi inte detta kan vi inte
                // göra någon jämförelse då shortDist antingen är odefinierat
                // eller har ett initialiseringsvärde som jag själv satt (som
                // kan vara mindre än någon av vägarna som anges).
                if(firstLoop)
                {
                    shortDist = dist;
                    firstLoop = false;

                    result[1] = i+1;
                    result[2] = j+1;
                }
                else if(dist < shortDist)
                {
                    shortDist = dist;

                    result[1] = i+1;
                    result[2] = j+1;
                }
            }
        }

        return result;
    }

    public static double langd(double[] a, double[][] b, double[] c)
    {
        double result = 0.0;
        boolean firstLoop = true;
        
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < b[i].length; j++)
            {
                double dist = a[i] + b[i][j] + c[j];

                if(firstLoop)
                {
                    result = dist;
                    firstLoop = false;
                }
                else if(dist < result)
                {
                    result = dist;
                }
            }
        }

        return result;
    }
}
