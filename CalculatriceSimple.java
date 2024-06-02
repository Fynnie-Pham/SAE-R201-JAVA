public class CalculatriceSimple {
    //Partie 1:
    public static void main(String[] args) {
        Nombre six = new Nombre(6);
        Nombre dix = new Nombre(10);
        Nombre zero = new Nombre(0);
        Nombre un = new Nombre(1);

        try {
            Operation div = new Division(six, zero);
                System.out.println(div+" = "+div.valeur());
        }
        catch(ArithmeticException e){
                System.out.println("On ne peut pas diviser par 0");
            }

        Operation add= new  Addition(dix,un);
        Operation mul = new Multiplication(un,un);
        System.out.println(add+" = "+add.valeur());
        System.out.println(mul+" = "+mul.valeur());
    }
    
}

