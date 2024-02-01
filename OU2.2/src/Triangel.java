public class Triangel {

    public static double Area (double base, double height) {
        return (base*height);
    }

    public static double Circumference (double a, double b, double c) {
        return a+b+c;
    }

    public static double Median (double a, double b, double c) {
        return 0.5*(Math.sqrt(2*b*b+2*c*c-a*a));
    }

    public static double Bisector(double b, double c, double alfa) {
        return (2*b*c*Math.cos(alfa/2))/(b+c);
    }

    public static double semiperimeter (double a, double b, double c)
    {
        return Circumference(a,b,c)/2;
    }

    public static double Omskrivna_cirkeln(double a, double b, double c) {
        double s = semiperimeter(a,b,c);
        double r = (a*b*c)/(4*(Math.sqrt(s*(s-a)*(s-b)*(s-c))));
        return r;
    }

    public static double Inskrivna_cirkeln(double a, double b, double c) {
        double s = semiperimeter(a,b,c);
        double r = Math.sqrt(((s-a)*(s-b)*(s-c))/s);
        return r;
    }
}
