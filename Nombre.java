public class Nombre extends Expression {
    private int valeurNombre;
    public Nombre(int unevaleur)
    {
        this.valeurNombre = unevaleur;
    }

    public int valeur()
    {
        return this.valeurNombre;
    }

    public String toString()
    {
        return "" + this.valeurNombre;
    }
}
