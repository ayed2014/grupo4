package TP3.Ejercicio1;

public class PilaE implements Pila {
    private int tope;
    private Object[] conjuntoDeDatos;

    public PilaE(){
        tope = 0;
        conjuntoDeDatos = new Object[5];
    }

    public void apilar(Object x){
        if (tope != conjuntoDeDatos.length){
            conjuntoDeDatos[tope] = x;
            tope++;
        } else {
            agrandarArreglo();
            conjuntoDeDatos[tope] = x;
            tope++;
        }
    }

    public void desapilar() throws ExcepcionPilaVacia {
        if (!esVacia()){
            tope--;
        } else {
            throw new ExcepcionPilaVacia();
        }
    }

    public Object verTope() throws ExcepcionPilaVacia {
        if (tope == 0){
            throw new ExcepcionPilaVacia();
        } else {
            return conjuntoDeDatos[tope-1];
        }
    }

    public boolean esVacia(){
        return tope == 0;
    }

    private void agrandarArreglo(){
        Object[] nuevoConjuntoDeDatos = new Object[conjuntoDeDatos.length+5];
            for (int i = 0; i<conjuntoDeDatos.length; i++){
                nuevoConjuntoDeDatos[i] = conjuntoDeDatos[i];
            }
        conjuntoDeDatos = nuevoConjuntoDeDatos;
    }

    public void vaciar(){
        tope = 0;
    }
}
