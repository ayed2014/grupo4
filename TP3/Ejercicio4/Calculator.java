package TP3.Ejercicio4;

import TP3.Ejercicio1.ExcepcionPilaVacia;
import TP3.Ejercicio1.Pila;
import TP3.Ejercicio1.PilaE;

/**
 * Clase que representa la calculadora de ecuaciones
 */
public class Calculator {
    private Pila calculatingMachine;
    private Double solution;

    /**
     * Construye la calculadora creando una pila (como asistente para el calculo)
     * y ejecutando el metodo encargado de calcular
     * @param equation la ecuacion en orden posfijo a calcular
     */
    public Calculator(String[] equation){
        calculatingMachine = new PilaE();
        calculate(equation);
    }

    /**
     * Calcula la solucion de la ecuacion
     * Recorre la ecuacion, cuando encuentra un numero lo mete a la pila
     * Cuando encuentra un operador, realiza la operacion con los dos ultimos numeros de la pila (los ve y los retira)
     * y el resultado lo mete en la pila
     * @param toCalculate
     */
    private void calculate(String[] toCalculate){
        for (String aToCalculate : toCalculate) {
            if (aToCalculate.equals("*")) {
                try {
                    Double second = (Double) calculatingMachine.verTope();
                    calculatingMachine.desapilar();
                    Double first = (Double) calculatingMachine.verTope();
                    calculatingMachine.desapilar();
                    Double semi = (first) * (second);
                    calculatingMachine.apilar(semi);
                } catch (ExcepcionPilaVacia excepcionPilaVacia) {
                    excepcionPilaVacia.printStackTrace();
                }
            } else if (aToCalculate.equals("+")) {
                try {
                    Double second = (Double) calculatingMachine.verTope();
                    calculatingMachine.desapilar();
                    Double first = (Double) calculatingMachine.verTope();
                    calculatingMachine.desapilar();
                    Double semi = (first) + (second);
                    calculatingMachine.apilar(semi);
                } catch (ExcepcionPilaVacia excepcionPilaVacia) {
                    excepcionPilaVacia.printStackTrace();
                }
            } else if (aToCalculate.equals("-")) {
                try {
                    Double second = (Double) calculatingMachine.verTope();
                    calculatingMachine.desapilar();
                    Double first = (Double) calculatingMachine.verTope();
                    calculatingMachine.desapilar();
                    Double semi = (first) - (second);
                    calculatingMachine.apilar(semi);
                } catch (ExcepcionPilaVacia excepcionPilaVacia) {
                    excepcionPilaVacia.printStackTrace();
                }
            } else if (aToCalculate.equals("/")) {
                try {
                    Double second = (Double) calculatingMachine.verTope();
                    calculatingMachine.desapilar();
                    Double first = (Double) calculatingMachine.verTope();
                    calculatingMachine.desapilar();
                    Double semi = (first) / (second);
                    calculatingMachine.apilar(semi);
                } catch (ExcepcionPilaVacia excepcionPilaVacia) {
                    excepcionPilaVacia.printStackTrace();
                }
            } else {
                Double number = Double.parseDouble(aToCalculate);
                calculatingMachine.apilar(number);
            }
        }

        try {
            solution = Double.parseDouble(""+calculatingMachine.verTope());
        } catch (ExcepcionPilaVacia excepcionPilaVacia) {
            excepcionPilaVacia.printStackTrace();
        }
    }

    /**
     * Devuelve la solucion de la ecuacion
     * @return la solucion
     */
    public Double getSolution(){
        return solution;
    }

}
