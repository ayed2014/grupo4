package TP4.Ejercicio1;

import java.util.Scanner;

public class PalindromeTester {
    public static void main(String[] args) {
        System.out.println("Ingrese una frase para ver si es palindrome: ");
        Scanner scanner = new Scanner(System.in);
        String toAnalise = scanner.nextLine();
        toAnalise.toLowerCase();
        Palindrome dynamicP = new Palindrome(toAnalise, true);
        Palindrome staticP = new Palindrome(toAnalise, false);
        if (dynamicP.isPalindrome() && staticP.isPalindrome()){
            System.out.println("La frase es palindrome");
        } else {
            System.out.println("La frase no es palindrome");
        }
    }
}
