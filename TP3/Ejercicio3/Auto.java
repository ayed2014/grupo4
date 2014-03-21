package TP3.Ejercicio3;

/**
 * Created with IntelliJ IDEA.
 * User: Agustin
 * Date: 20/03/14
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */
public class Auto {

    private String patente;
    private String marca;
    private String modelo;
    private String color;

    /**
     * constructor de la clase auto
     */
    public Auto(String patente, String marca, String modelo, String color) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    /**
     * Devuelve la patente del auto .
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Devuelve la marca del auto .
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Devuelve el moedelo del auto.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Devuelve el color del auto.
     */
    public String getColor() {
        return color;
    }

    /**
     * Cambia el color del auto por un string que hace referencia al color.
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * Cambia la patente del auto por otra diferente.
     */
    public void setPatente(String patente) {
        this.patente = patente;
    }


}
