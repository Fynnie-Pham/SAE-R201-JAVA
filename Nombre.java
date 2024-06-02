public class Nombre extends Expression{
    private double valeurNombre;
    public Nombre(double valeur)
    {
        this.valeurNombre = valeur;
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
