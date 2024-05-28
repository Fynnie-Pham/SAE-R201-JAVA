public abstract class Operation {
    private Nombre operande1;
    private Nombre operande2;

    public Operation(Nombre operande1, Nombre operande2)
    {
        this.operande1 = operande1;
        this.operande2 = operande2;
    }

    public abstract int valeur();

    public Nombre getOperande1()
    {
        return this.operande1;
    }
    public Nombre getOperande2()
    {
        return this.operande2;
    }
}