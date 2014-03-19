package TP3.Ejercicio4;

import TP3.Ejercicio1.ExcepcionPilaVacia;
import TP3.Ejercicio1.Pila;
import TP3.Ejercicio1.PilaE;

public class Calculator {
    private Pila calculatingMachine;
    private Double solution;

    public Calculator(String[] equation){
        calculatingMachine = new PilaE();
        calculate(equation);
    }

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

    public Double getSolution(){
        return solution;
    }

}
