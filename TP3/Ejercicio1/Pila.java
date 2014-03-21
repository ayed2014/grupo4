package TP3.Ejercicio1;

/**
 * Interfaz que representa la funcionalidad de una pila
 */
public interface Pila {

    /**
     * Se apila un objeto cualquiera en la pila
     * @param x el objeto a apilar
     */
    public void apilar(Object x);

    /**
     * Se desapila el objeto del tope de la pila
     * @throws ExcepcionPilaVacia
     */
    public void desapilar() throws ExcepcionPilaVacia;

    /**
     * Permite ver el objeto en el tope de la pila sin desapilarlo
     * @return el objeto en el tope
     * @throws ExcepcionPilaVacia
     */
    public Object verTope() throws ExcepcionPilaVacia;

    /**
     * Informa si la pila esta vacia
     * @return booleano que representa si la pila esta vacia o no
     */
    public boolean esVacia();

    /**
     * Vacia la pila
     */
    public void vaciar();

}
