package TP3.Ejercicio1;

/**
 * Created by cristian on 16/03/14.
 */
public class Nodo {
    private Object elemento;
    private Nodo referencia;

    public Nodo(Object nuevoElemento, Nodo nuevaReferencia){
        elemento = nuevoElemento;
        referencia = nuevaReferencia;
    }

    public Object getElemento() {
        return elemento;
    }

    public Nodo getReferencia() {
        return referencia;
    }
}
