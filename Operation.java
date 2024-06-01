

public abstract class Operation extends Expression{
   
    private Expression operande1; 
    private Expression operande2;

    public Operation(Expression operande1, Expression operande2)
    {
        this.operande1 = operande1;
        this.operande2 = operande2;
    }
    public abstract double valeur();

    public Expression getOperande1()
    {
        return this.operande1;
    }
    public Expression getOperande2()
    {
        return this.operande2;
    }
}