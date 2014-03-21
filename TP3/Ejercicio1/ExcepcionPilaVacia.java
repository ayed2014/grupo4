package TP3.Ejercicio1;

/**
 * Clase que representa una excepcion para informar que una pila esta vacia
 */
public class ExcepcionPilaVacia extends Exception {

    /**
     * Construye la excepción, e informa con una impresion que la pila esta vacia
      */
    public ExcepcionPilaVacia(){
        System.out.println("Error: la pila está vacia");
    }
}
