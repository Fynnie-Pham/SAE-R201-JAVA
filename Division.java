public class Division extends Operation {
    public Division(Expression operande1, Expression operande2) throws ArithmeticException
    {
        super(operande1, operande2);
        if (getOperande2().valeur() == 0)
            throw new ArithmeticException("Le dénominateur ne peut pas être zéro.");
    }

    public int valeur()
    {
        return getOperande1().valeur()/getOperande2().valeur();
    }

    public String toString()
    {
        return ""+getOperande1().valeur() + " / " + getOperande2().valeur();
    }
}