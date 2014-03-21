package TP3.Ejercicio1;

/**
 * Clase que representa un nodo que se almacena en pila
 * Contiene el objeto almacenado y una referencia al nodo que se encuentra anterior a esta
 */
public class Nodo {
    private Object elemento;
    private Nodo referencia;

    /**
     * Construye el nodo
     * @param nuevoElemento     el objeto que contiene a almacenar
     * @param nuevaReferencia   la referencia del nodo anterior a este
     */
    public Nodo(Object nuevoElemento, Nodo nuevaReferencia){
        elemento = nuevoElemento;
        referencia = nuevaReferencia;
    }

    /**
     * Devuelve el objeto que el nodo contiene
     * @return  un objeto que representa al que esta contenido por el nodo
     */
    public Object getElemento() {
        return elemento;
    }

    /**
     * Devuelve la referencia al nodo anterior
     * @return el nodo anterior al nodo actual
     */
    public Nodo getReferencia() {
        return referencia;
    }
}
