import java.util.ArrayList;

public class CalculatriceSimple {

    //Question bonus:
    public static Expression fabriqueExpression(String e) {
        String stringNum = "";  //stringNum va contenir les numéros en forme string
        char operation = 0; //operation va conternir une caractere d'opération (+,-,*,/)

        ArrayList<Expression> lesExpressions = new ArrayList<>(); //cette array list va contenir des expressions 

        for (int i = 0; i < e.length(); i++) { //boucle pour traverse tout la chaine de caractère e
            char c = e.charAt(i); //c va contenir le caractère à la possion i

            if (c == '(') { //si c est une ouvert-parenthèse pour qu'on va prend tous les caractères entre les parenthèse
                int j = i + 1;
                StringBuilder subExpr = new StringBuilder(); // créer une chaine de caractère qui contient tous les caractères entre parenthères

                while (e.charAt(j) == ')' && j < e.length()) { 
                    subExpr.append(e.charAt(j));
                    j++;
                }
                lesExpressions.add(fabriqueExpression(subExpr.toString())); // il va fabriquer et ajouter l'expressions entre parenthèse dans l'arraylist lesExpressions 
                i = j - 1; //
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
                return lesExpressions.get(0); // si c'est aucun cas c'est-à-dire que c'est une nombre donc il retourne une expression nombre
        }
    }

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
    // Partie Bonus: - Les testes pour les methodes fabrique Expression 
        Expression exp1 = fabriqueExpression("333");
        System.out.println(exp1 + " = " + exp1.valeur());
        Expression exp2 = fabriqueExpression("3+7");
        System.out.println(exp2 + " = " + exp2.valeur());
        Expression exp3 = fabriqueExpression("(3+7)*3");
        System.out.println(exp3 + " = " + exp3.valeur());
    
    }
    
}

