package TP8;

/**
 * Created by cristian on 18/04/14.
 */
public class Lampara implements Comparable{
    private String codigo;
    private int watts;
    private String tipo;
    private int cantidad;

    public Lampara(String codigo){
        this.codigo = codigo;
    }

    public Lampara(String codigo, String tipo, int watts, int cantidad){
        this.codigo = codigo;
        this.tipo = tipo;
        this.watts = watts;
        this.cantidad = cantidad;
    }

    public void informar(){
        System.out.println("Codigo de lampara: " +codigo);
        System.out.println("Tipo de lampara: " +tipo);
        System.out.println("Watts: " +watts);
        System.out.println("Stock: " +cantidad +"\n");
    }

    public void setTipo(String nuevoTipo){
        tipo = nuevoTipo;
    }

    public void setWatts(int nuevoWatts){
        watts = nuevoWatts;
    }

    public void setStock(int nuevaCantidad){
        cantidad = nuevaCantidad;
    }

    public int compareTo(Object o) {
        Lampara temp = (Lampara) o;
        return this.codigo.compareTo(temp.codigo);
    }
}
