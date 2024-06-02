import java.util.ArrayList;

public class TestOperation {

    //Question bonus:
    public static Expression fabriqueExpression(String e) {
        e = e.trim();
        String stringNum = "";  //stringNum va contenir les numéros en forme string
        char operation = 0; //operation va conternir une caractere d'opération (+,-,*,/)

        ArrayList<Expression> lesExpressions = new ArrayList<>(); //cette array list va contenir des expressions 

        for (int i = 0; i < e.length(); i++) { //boucle pour traverse tout la chaine de caractère e
            char c = e.charAt(i); //c va contenir le caractère à la possion i

            if (c ==' '){
                continue;
            }
            if (c == '(') { //si c est une ouvert-parenthèse pour qu'on va prend tous les caractères entre les parenthèse
                int parens = 1;
                int j = i + 1;
                StringBuilder subExpr = new StringBuilder(); // créer une chaine de caractère qui contient tous les caractères entre parenthères

                while (parens > 0 && j < e.length()) { //Boucle pour recopier tous les caractères entre parenthèse au subExpre
                    if (e.charAt(j) == '(') parens++; //S'il le caractère est une autre ( donc le nombre de parens va +1
                    if (e.charAt(j) == ')') parens--; //S'il le caractère est une autre ) donc le nombre de parens va -1
                    if (parens > 0) subExpr.append(e.charAt(j)); //si il y a toujour parens reste, il va ajouter les caractères dans subExpr
                    j++;
                }

                lesExpressions.add(fabriqueExpression(subExpr.toString())); // il va fabriquer et ajouter l'expressions entre parenthèse dans l'arraylist lesExpressions 
                i = j - 1;
                continue;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/') { //les tests si c'est une opération
                if (!stringNum.isEmpty()) { //une teste qui va tester si le chaine est vide
                    lesExpressions.add(new Nombre(Double.parseDouble(stringNum.trim()))); //fabrique une expression nombre et ajouter dans l'arraylist lesExpressions
                    stringNum = ""; // initialiser le stringNum au vide
                }
                operation = c; //operation prends l'opération
            } else {
                stringNum += c;// si c n'est pas une caracter d'operation donc il va ajouter dans le stringNum
            }
        }

        if (!stringNum.isEmpty()) { //une teste qui permet voir si le chaine stringNum est vide
            lesExpressions.add(new Nombre(Double.parseDouble(stringNum.trim()))); // ajouter l'expression Nombre(stringNum) dans l'arraylist lesExpressions
        }

        if (lesExpressions.size() == 1) {
            return lesExpressions.get(0); // si le taille d'arrayList c'est-à-dire que c'est une nombre donc il retourne une expression nombre
        }
        switch (operation) { //une switch qui permet tester tout les cas pour les expressions
            case '+': //cas addition
                return new Addition(lesExpressions.get(0), lesExpressions.get(1)); // il retourne une addition de 1er element et 2eme de lesExpressions
            case '-':
                return new Soustraction(lesExpressions.get(0), lesExpressions.get(1));// il retourne une soustraction de 1er element et 2eme de lesExpressions
            case '*':
                return new Multiplication(lesExpressions.get(0), lesExpressions.get(1));// il retourne une multiplication de 1er element et 2eme de lesExpressions
            case '/':
                return new Division(lesExpressions.get(0), lesExpressions.get(1));// il retourne une division de 1er element et 2eme de lesExpressions
            default:
                return lesExpressions.get(0);    //throw new IllegalArgumentException("Opérateur non supporté : " + operation); 
        }
    }
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
        Expression multiplication = new Multiplication(dix, trois); // (10 * 3)
        Expression addition = new Addition(neuf, multiplication);    // (9 + (10 * 3))
        System.out.println(addition + " = " + addition.valeur());  // affiche (9 + (10 * 3)) = 39

        // Opération composée : ((20 - 5) * (4 + 6))
        Expression vingt = new Nombre(20);
        Expression cinq = new Nombre(5);
        Expression quatre = new Nombre(4);
        Expression six = new Nombre(6);
        Expression soustraction = new Soustraction(vingt, cinq);   // (20 - 5)
        addition = new Addition(quatre, six);         // (4 + 6)
        multiplication = new Multiplication(soustraction, addition); // ((20 - 5) * (4 + 6))
        System.out.println(multiplication + " = " + multiplication.valeur());  // affiche ((20 - 5) * (4 + 6)) = 150

        // Nouvelle opération composée : ((15 + 5) - (3 * 4))
        Expression quinze = new Nombre(15);
        addition = new Addition(quinze, cinq);          // (15 + 5)
        multiplication = new Multiplication(trois, quatre); // (3 * 4)
        soustraction = new Soustraction(addition, multiplication); // ((15 + 5) - (3 * 4))
        System.out.println(soustraction + " = " + soustraction.valeur());  // affiche ((15 + 5) - (3 * 4)) = 11
        
        // Partie Bonus: - Les testes pour les methodes fabrique Expression
        System.out.println("Question bonus:");
        Expression exp1 = fabriqueExpression("333");
        System.out.println(exp1 + " = " + exp1.valeur());
        Expression exp2 = fabriqueExpression("3+7");
        System.out.println(exp2 + " = " + exp2.valeur());
        Expression exp4 = fabriqueExpression("3*3");
        System.out.println(exp4 + " = " + exp4.valeur());
        Expression exp3 = fabriqueExpression("(3+7)*3");
        System.out.println(exp3 + " = " + exp3.valeur());
        
    }
    
}