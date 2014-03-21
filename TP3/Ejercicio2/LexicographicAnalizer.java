package TP3.Ejercicio2;


import TP3.Ejercicio1.ExcepcionPilaVacia;
import TP3.Ejercicio1.Pila;
import TP3.Ejercicio1.PilaE;

import java.io.*;
import java.util.Scanner;

/**
 * Clase representante del analizador lexicografico
 */
public class LexicographicAnalizer {

    private String fileUrl;
    private Pila bracketsStack;

    private final char KEY_A = '{';
    private final char KEY_C = '}';
    private final char PAREN_A = '(';
    private final char PAREN_C = ')';
    private final char BRACKET_A = '[';
    private final char BRACKET_C = ']';

    /**
     * Constructor del analizador que inicializa una pila
     * Tambien encargado de ejecutar un metodo para pedir el directorio del archivo a analizar
     */
    public LexicographicAnalizer(){
        askURL();
        bracketsStack = new PilaE();
    }

    /**
     * Interaccion con el usuario, que pide la direccion del archivo a analizar
     */
    private void askURL(){
        System.out.println("Ingrese la url del archivo a analizar");
        System.out.println("Debe seguir el siguiente formato 'C:\\Carpeta\\testing.txt'\n");
        Scanner scan = new Scanner(System.in);
        fileUrl = scan.next();
    }

    /**
     * Analiza un archivo linea por linea (Si no lo encuentra, informa de esto y termina el programa)
     * En cada linea analiza todos los caracteres en busqueda de parentesis, corchetes y llaves
     * Si encuentra cualquiera de estos, pero en su forma abierta, lo agrega a una pila
     * Si enceuntra cualquiera de estos, pero en su forma cerrada, ve el elemento tope de la pila
     *
     * Si el elemento tope no coincide (Para ser especifico, si el caracter actual
     * es un corchete cerrado y el elemento en el tope es una llave), devuelve un valor
     * booleano que representa que el archivo no esta correctamente escrito
     *
     * Al finalizar de analizar, devuelve si la pila esta vacia o, por lo menos, con un elemento
     * Si esta vacia significa que el archivo esta escrito correctamente
     * Si tiene un elemento (por lo menos), significa que esta mal escrito (Para ser especifico,
     * tiene un elemento abierto sin cerrar)
     * @return si el archivo esta correctamente escrito o no
     */
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
