public class Polylinje
{
    private Punkt[] horn;
    private String farg;
    private int bredd;

    public Polylinje()
    {
        this.bredd = 1;
        this.farg = "svart";

        this.horn = new Punkt[0];
    }

    public Polylinje(Punkt[] horn)
    {
        this.bredd = 1;
        this.farg = "svart";

        this.horn = new Punkt[horn.length];
        for(int i = 0; i < horn.length; i++)
        {
            this.horn[i] = new Punkt(horn[i]);
        }
    }

    public String toString()
    {
        String value = "{";

        value += "[";
        for(int i = 0; i < this.horn.length; i++)
        {
            value += this.horn[i].toString();
        }
        value += "], " + this.farg + ", " + this.bredd + "}";

        return value;
    }

    public Punkt[] getHorn()
    {
        Punkt[] horn = new Punkt[this.horn.length];

        for(int i = 0; i < this.horn.length; i++)
        {
            horn[i] = new Punkt(this.horn[i]);
        }

        return horn;
    }

    public String getFarg()
    {
        return this.farg;
    }
    public void setFarg(String farg)
    {
        this.farg = farg;
    }

    public int getBredd()
    {
        return this.bredd;
    }
    public void setBredd(int bredd)
    {
        this.bredd = bredd;
    }

    public double langd()
    {
        double distance = 0.0;

        if(this.horn.length <= 1)
        {
            return 0.0;
        }

        // -2 för att sista inte har en följande punkt
        for(int i = 0; i <= (this.horn.length - 2); i++)
        {
            distance += this.horn[i].avstand(this.horn[i + 1]);
        }

        return distance;
    }

    public void laggTill(Punkt p)
    {
        Punkt[] h = new Punkt[this.horn.length + 1];

        for(int i = 0; i < this.horn.length; i++)
        {
            h[i] = this.horn[i];
        }

        h[h.length - 1] = new Punkt(p);

        this.horn = h;
    }

    public void laggTillFramfor(Punkt p, String namn)
    {
        Punkt[] h = new Punkt[this.horn.length + 1];

        boolean found = false;
        for(int i = this.horn.length - 1; i >= 0; i--)
        {
            // Hitta den punkten vi vill sätta in den nya punkten framför.
            if(this.horn[i].getNamn().equals(namn))
            {
                found = true;

                h[i + 1] = this.horn[i];
                h[i] = new Punkt(p);

                continue;
            }

            if(found)
            {
                h[i] = this.horn[i];
            }
            else
            {
                h[i + 1] = this.horn[i];
            }
        }

        this.horn = h;
    }

    public void taBort(String namn)
    {
        Punkt[] h = new Punkt[this.horn.length - 1];

        int count = 0;
        boolean found = false;
        for(int i = 0; i < this.horn.length; i++)
        {
            if(this.horn[i].getNamn().equals(namn))
            {
                found = true;
                continue;
            }

            if(count < h.length)
            {
                h[count++] = this.horn[i];
            }
        }

        if(found)
            this.horn = h;
    }

    public class PolylinjeIterator
    {
        private int aktuell = -1;

        public PolylinjeIterator()
        {
            if(Polylinje.this.horn.length > 0)
            {
                aktuell = 0;
            }
        }

        public boolean finnsHorn()
        {
            return aktuell != -1;
        }

        public Punkt horn() throws java.util.NoSuchElementException
        {
            if(!this.finnsHorn())
            {
                throw new java.util.NoSuchElementException("slut av iterationen");
            }

            return Polylinje.this.horn[aktuell];
        }

        public void gaFram()
        {
            if(aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
            {
                aktuell++;
            }
            else
            {
                aktuell = -1;
            }
        }
    }
}
