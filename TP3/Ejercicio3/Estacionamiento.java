package TP3.Ejercicio3;

import TP3.Ejercicio1.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Agustin
 * Date: 20/03/14
 * Time: 17:45
 * To change this template use File | Settings | File Templates.
 */
public class Estacionamiento {

    private PilaE playa;
    private PilaE vereda;

    private int dinero;
    private int count;

    /**
     * Constructor de la clase Estacionamiento.
     */
    public Estacionamiento() {
        playa = new PilaE();
        vereda = new PilaE();
        count = 0;
    }
    /**
     * Desapila los elementos de la pila vereda y los apila en la pila playa nuevamente
     */
    public void ingresarAutosDeLaVereda(){
        while (!vereda.esVacia()){
            try {
                playa.apilar(vereda.verTope());
                vereda.desapilar();
            } catch (ExcepcionPilaVacia excepcionPilaVacia) {
                System.out.println("No hay mas coches en la vereda");
            }
        }
    }

    /**
     * Le pide al usuario una patente que seria la patatente del auto a retirar. La compara con la patente del auto en
     * el punto de acceso de la pila, si son iguales lo remueve, si no lo apila en la pila vereda y cuando encuentra al
     * correcto lo desapila y apila nuevamente los autos en la pila vereda a la pila playa.
     */
    public void sacarAuto(String s) {
        while (!playa.esVacia()) {
            try {
            Auto seleccionado = (Auto) playa.verTope();
            if (seleccionado.getPatente().equals(s)) {
                playa.desapilar();
                System.out.println("Auto encontrado y retirado");
                count--;
                return;
            } else {
                vereda.apilar(seleccionado);
                playa.desapilar();
            }
            } catch (ExcepcionPilaVacia excepcionPilaVacia){
                System.out.println("No queda ningun auto a retirar de la playa de estacionamiento");
            }
        }
        System.out.println("Auto no encontrado");
    }

    /**
     * devuelve el dinero recolectado
     */
    public int getDinero() {
        return dinero;
    }

    /**
     * Le pide al usuario ingresar 4 strings, patente, marca, modelo, color. Crea un auto y lo agrega a la pila playa.
     */
    public void agregarAuto() {
        if (count <= 50) {
            String pat, mar, mod, col;
            Scanner scan = new Scanner(System.in);
            System.out.println("Ingrese la patente del auto a ser estacionado:");
            pat = scan.next();
            System.out.println("Ingrese la marca del auto a ser estacionado:");
            mar = scan.next();
            System.out.println("Ingrese el modelo del auto a ser estacionado:");
            mod = scan.next();
            System.out.println("Ingrese el color del auto a ser estacionado:");
            col = scan.next();

            Auto auto = new Auto(pat, mar, mod, col);
            count++;
            playa.apilar(auto);
            dinero += 5;
        } else {
            System.out.println("No se pueden agregar mas autos, playa de estacionamiento llena.");
        }
    }

    /**
     * Pide al usuario un string que representa la patente del auto que se quiere retirar, llama al metodo sacarAuto()
     * y le pasa el string para que lo busque.
     */
    public void autoARetirar() {
        System.out.println("Ingrese la patente del auto a ser retirado:");
        Scanner scan = new Scanner(System.in);
        String patenteARetirar = scan.nextLine();
        sacarAuto(patenteARetirar);
        ingresarAutosDeLaVereda();
    }

    /**
     * Le suma $5 a la variable dinero por cada auto que se retira de la pila playa.
     */
    public void debitar(){
        dinero = dinero + (count*5);
    }

    /**
     * empieza el programa y deja al usuario elejir que opcion desea realizar.
     */
    public void Start() {

        Boolean b = true;

        for (int i = 0; i < 100; i++) {
            if (b) {
                System.out.println("Seleccione una opcion del 1 al 4:");
                System.out.println("1) Agregar Auto");
                System.out.println("2) Sacar Auto");
                System.out.println("3) Mostrar Dinero");
                System.out.println("4) Dia Finalizado (Debitar a autos estacionados)");
                System.out.println("5) Salir");
                System.out.println("-----------------------------------------\n");
                Scanner scan1 = new Scanner(System.in);
                int opcion = scan1.nextInt();

                switch (opcion) {
                    case 1:
                        agregarAuto();
                        break;
                    case 2:
                        autoARetirar();
                        break;
                    case 3:
                        System.out.println(getDinero());
                        break;
                    case 4:
                        debitar();
                        break;
                    case 5:
                        b = false;
                        break;
                }
            }
        }
    }


}



