package TP3.Ejercicio1;

/**
 * Created by cristian on 14/03/14.
 */
public interface Pila {

    public void apilar(Object x);
    public void desapilar() throws ExcepcionPilaVacia;
    public Object verTope() throws ExcepcionPilaVacia;
    public boolean esVacia();
    public void vaciar();

}
