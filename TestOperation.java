public class TestOperation {
    public static void main(String[] args)
    {   
        // Exemple initial : (17 - 2) / (2 + 3)
        Expression deux = new Nombre(2) ;
        Expression trois = new Nombre(3) ;
        Expression dixSept = new Nombre(17) ;
        Expression s = new Soustraction(dixSept, deux) ;
        Expression a = new Addition(deux, trois) ;
        Expression d = new Division(s, a) ;
        System.out.println(d + " = " + d.valeur()) ; // affiche ((17 - 2) / (2 + 3)) = 3 

        // Opération composée : (9 + (10 * 3))
        Expression neuf = new Nombre(9);
        Expression dix = new Nombre(10);
        Expression trois = new Nombre(3);
        Expression multiplication = new Multiplication(dix, trois); // (10 * 3)
        Expression addition = new Addition(neuf, multiplication);    // (9 + (10 * 3))
        System.out.println(addition + " = " + addition.valeur());  // affiche (9 + (10 * 3)) = 39

        // Opération composée : ((20 - 5) * (4 + 6))
         Expression vingt = new Nombre(20);
         Expression cinq = new Nombre(5);
         Expression quatre = new Nombre(4);
         Expression six = new Nombre(6);
         Expression soustraction = new Soustraction(vingt, cinq);   // (20 - 5)
         Expression addition = new Addition(quatre, six);         // (4 + 6)
         Expression multiplication = new Multiplication(soustraction, addition); // ((20 - 5) * (4 + 6))
         System.out.println(multiplication + " = " + multiplication.valeur());  // affiche ((20 - 5) * (4 + 6)) = 150

        // Nouvelle opération composée : ((15 + 5) - (3 * 4))
         Expression quinze = new Nombre(15);
         Expression cinq = new Nombre(5);
         Expression trois = new Nombre(3);
         Expression quatre = new Nombre(4);
         Expression addition = new Addition(quinze, cinq);          // (15 + 5)
         Expression multiplication = new Multiplication(trois, quatre); // (3 * 4)
         Expression soustraction = new Soustraction(addition, multiplication); // ((15 + 5) - (3 * 4))
         System.out.println(soustraction + " = " + soustraction.valeur());  // affiche ((15 + 5) - (3 * 4)) = 11
        
    }
    
}
