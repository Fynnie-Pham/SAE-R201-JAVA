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
        catch(Exception e){
                System.out.println(e);
            }

        Operation add= new  Addition(dix,un);
        Operation mul = new Multiplication(un,un);
        System.out.println(add+" = "+add.valeur());
        System.out.println(mul+" = "+mul.valeur());
            
    //Partie 2: 
        Expression deux = new Nombre(2);
        Expression trois = new Nombre(3);
        Expression dixSept = new Nombre(17);
        Expression s = new Soustraction(dixSept, deux);
        Expression a = new Addition(deux, trois);
        Expression d = new Division(s, a);
        System.out.println(d +"="+d.valeur());
    }
}
