public class Nombre extends Expression {
    private double valeurNombre;
    public Nombre(double d)
    {
        this.valeurNombre = d;
    }

    public double valeur()
    {
        return this.valeurNombre;
    }

    public String toString()
    {
        return "" + this.valeurNombre;
    }
}
