public class Punkt
{
    private int x, y;
    private String namn;

    public Punkt(String namn, int x, int y)
    {
        this.namn = namn;
        this.x = x;
        this.y = y;
    }

    public Punkt(Punkt other)
    {
        this.namn = other.namn;
        this.x = other.x;
        this.y = other.y;
    }

    public String toString()
    {
        return "(" + this.namn + " " + this.x + " " + this.y + ")";
    }

    public boolean equals(Punkt other)
    {
        return this.x == other.getX() && this.y == other.getY() && this.namn.equals(other.getNamn());
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setX(int value)
    {
        this.x = value;
    }

    public void setY(int value)
    {
        this.y = value;
    }

    public String getNamn()
    {
        return this.namn;
    }

    public void setNamn(String namn)
    {
        this.namn = namn;
    }

    public double avstand(Punkt other)
    {
        double a = (this.x - other.getX())*(this.x - other.getX());
        double b = (this.y - other.getY())*(this.y - other.getY());

        return Math.sqrt(a + b);
    }
}
