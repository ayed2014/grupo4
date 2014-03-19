package TP3.Ejercicio4;

import java.util.Scanner;

public class EquationSolver {

    public EquationSolver(){
        askEquation();
    }

    private void askEquation(){
        System.out.println("A continuación debera ingresar la ecuacion a calcular \n");
        System.out.println("IMPORTANTE");
        System.out.println("La ecuacion debe ser valida (En orden infijo y sin espacios)");
        System.out.println("El primer caracter debe ser un dígito. Si desea calcular por ejemplo -2+4, " +
                "debera ingresar 4-2");
        System.out.println("Los operadores permitidos son +, -, *, / ");
        System.out.println("No deben haber paréntesis \n");

        Scanner scan = new Scanner(System.in);
        analiseEquation(scan.next());
    }

    private void analiseEquation(String equation){
        Calculator calculatingMachine;

        if ((equation.charAt(0)-48>=0)&&(equation.charAt(0)-48<=9)){
            for (int i=0; i<equation.length(); i++){
                if (!((equation.charAt(i)-48>=0)&&(equation.charAt(i)-48<=9))&&!(equation.charAt(i)=='+')
                        &&!(equation.charAt(i)=='-')&&!(equation.charAt(i)=='*')&&!(equation.charAt(i)=='/')){
                    System.out.println("\nEcuación con caracteres invalidos");
                    askEquation();
                    return;
                } else if ((equation.charAt(i)-48==0)&&(equation.charAt(i-1)=='/')){
                    System.out.println("\nNo puede ingresar un cero como divisor");
                    askEquation();
                    return;
                } else if ((equation.charAt(i)=='+')||(equation.charAt(i)=='-')||(equation.charAt(i)=='*')
                        ||(equation.charAt(i)=='/')){
                    if (i==equation.length()-1){
                        System.out.println("\nError: La ecuación no puede terminar con un operador");
                        askEquation();
                        return;
                    } else {
                        if (!((equation.charAt(i-1)-48>=0)&&(equation.charAt(i-1)-48<=9))
                                || !((equation.charAt(i+1)-48>=0)&&(equation.charAt(i+1)-48<=9))){
                            System.out.println("\nLa ecuación contiene operadores juntos");
                            askEquation();
                            return;
                        }
                    }
                }
            }

            calculatingMachine = new Calculator(new EquationFormat(equation).getPostfix());
            System.out.println("El resultado de la ecuación " +equation +" es: ");
            System.out.println(calculatingMachine.getSolution());

        } else {
            System.out.println("\nError: La ecuacion no empieza con un digito\n");
            askEquation();
        }
    }
}
