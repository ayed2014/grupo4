package TP3.Ejercicio1;

public class PilaD implements Pila{
    private Nodo tope;

    public PilaD(){
        tope = null;
    }

    @Override
    public void apilar(Object x) {
        tope = new Nodo(x, tope);
    }

    @Override
    public void desapilar() throws ExcepcionPilaVacia {
        if (tope == null){
            throw new ExcepcionPilaVacia();
        } else {
            tope = tope.getReferencia();
        }
    }

    @Override
    public Object verTope() throws ExcepcionPilaVacia {
        if (tope == null){
            throw new ExcepcionPilaVacia();
        } else {
            return tope.getElemento();
        }
    }

    @Override
    public boolean esVacia() {
        return tope == null;
    }

    @Override
    public void vaciar() {
        tope = null;
    }
}
