package TP3.Ejercicio2;


import TP3.Ejercicio1.ExcepcionPilaVacia;
import TP3.Ejercicio1.Pila;
import TP3.Ejercicio1.PilaE;

import java.io.*;
import java.util.Scanner;

public class LexicographicAnalizer {

    private String fileUrl;
    private Pila bracketsStack;

    private final char KEY_A = '{';
    private final char KEY_C = '}';
    private final char PAREN_A = '(';
    private final char PAREN_C = ')';
    private final char BRACKET_A = '[';
    private final char BRACKET_C = ']';

    public LexicographicAnalizer(){
        askURL();
        bracketsStack = new PilaE();
    }

    private void askURL(){
        System.out.println("Ingrese la url del archivo a analizar");
        System.out.println("Debe seguir el siguiente formato 'C:\\Carpeta\\testing.txt'\n");
        Scanner scan = new Scanner(System.in);
        fileUrl = scan.next();
        System.out.println(fileUrl);
    }

    public boolean analizer(){
        Character atTop;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileUrl)));
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                for (int i=0; i<currentLine.length(); i++){
                    if (currentLine.charAt(i)==KEY_A){
                        bracketsStack.apilar(KEY_A);
                    } else if (currentLine.charAt(i)==PAREN_A){
                        bracketsStack.apilar(PAREN_A);
                    } else if (currentLine.charAt(i)==BRACKET_A){
                        bracketsStack.apilar(BRACKET_A);
                    } else if (currentLine.charAt(i)==KEY_C){
                        atTop = (Character) bracketsStack.verTope();
                        if (atTop != KEY_A){
                            return false;
                        }
                        bracketsStack.desapilar();
                    } else if (currentLine.charAt(i)==PAREN_C){
                        atTop = (Character) bracketsStack.verTope();
                        if (atTop != PAREN_A){
                            return false;
                        }
                        bracketsStack.desapilar();
                    } else if (currentLine.charAt(i)==BRACKET_C){
                        atTop = (Character) bracketsStack.verTope();
                        if (atTop != BRACKET_A){
                            return false;
                        }
                        bracketsStack.desapilar();
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExcepcionPilaVacia excepcionPilaVacia) {
            return false;
        }
        return bracketsStack.esVacia();
    }
}
