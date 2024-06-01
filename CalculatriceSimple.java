
public class CalculatriceSimple {
    public static void main(String args[])
    {
        Nombre six = new Nombre(6);
        Nombre dix = new Nombre(10);
        Nombre deux = new Nombre(2);
        Nombre zero = new Nombre(0);

        Operation s = new Soustraction(dix, six);
        System.out.println(s + " = " + s.valeur()) ; // doit afficher : (10 – 6) = 4
        s = new Multiplication(dix, six);
        System.out.println(s + " = " + s.valeur()) ; // doit afficher : (10 * 6) = 60
        s = new Addition(dix, six);
        System.out.println(s + " = " + s.valeur()) ; // doit afficher : (10 + 6) = 16
        s = new Division(dix, deux);
        System.out.println(s + " = " + s.valeur()) ; // doit afficher : (10 / 2) = 5


        try {
            s = new Division(six, zero);
            System.out.println(s + " = " + s.valeur()) ; // doit afficher : Division par 0 impossible
        } catch (ArithmeticException e) {
            System.out.println("On ne peut pas diviser par 0");
        }
        
    }
}
