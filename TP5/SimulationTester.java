package TP5;

import java.util.Scanner;

public class SimulationTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int panesAmount;
        while (true){
            System.out.println("Ingrese la cantidad de ventanilla (de 3 a 10): ");
            panesAmount = scanner.nextInt();
            if (panesAmount >= 3 && panesAmount <=10){
                break;
            }
        }
        new PaneSimulation(panesAmount);
    }
}
