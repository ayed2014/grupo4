package TP3.Ejercicio4;

import TP3.Ejercicio1.ExcepcionPilaVacia;
import TP3.Ejercicio1.Pila;
import TP3.Ejercicio1.PilaE;

/**
 * Clase que representa la transformacion de la ecuacion en orden infijo a orden postfijo
 */
public class EquationFormat {

    private String[] postfix;
    private Pila almacenarSignos;

    /**
     * Constructor del formateador de la ecuacion
     * Incializa un arreglo que contendra la ecuacion en orden postfijo, una pila que sirve de asistente
     * y ejecuta el metodo para formatear
     * @param equation la ecuacion infija
     */
    public EquationFormat(String equation){
        postfix = new String[equation.length()];
        almacenarSignos = new PilaE();
        infixToPostfix(equation);
    }

    /**
     * Transforma la ecuacion infija en postfija (le agrega un igual al final de la ecuacion)
     *
     * Si encuentra un digito lo agrega a un string con los digitos (esto para poder calcular
     * ecuaciones con numeros de mas de un digito)
     *
     * Cuando encuentra un operador de tipo suma o resta, guarda el numero en el arreglo
     * y vuelve a inicializar la variable para construir numero, y si la pila esta vacia mete el operador en la pila,
     * si no esta vacia, va sacando los elementos uno por uno metiendolos en arreglo hasta que no quede ninguno y mete
     * el operador en cuestion (suma o resta)
     *
     * Cuando encuentra un operador de tipo multiplicacion o division, lo mete siempre a la pila, ademas de guardar
     * el numero en el arreglo y volver a inicializar la variable para construir un numero
     *
     * Cuando encuentra el signo igual, se fija si la pila esta vacia, si no lo esta retira cada elemento metiendolos
     * en el arreglo, ademas de guardar el numero en el arreglo.
     * @param calcEquation la ecuacion a transformar
     */
    private void infixToPostfix(String calcEquation){
        String equation = calcEquation+"=";
        String number = "";
        String[] equationElements;
        int elementsQuantity = 0;

        for (int i=0; i<equation.length(); i++){
            if ((equation.charAt(i)>=48)&&(equation.charAt(i)<=57)){
                number = number+equation.charAt(i);
            } else if (((equation.charAt(i)==43)||(equation.charAt(i)==45))&&(almacenarSignos.esVacia())){
                for (int j=0; j<postfix.length; j++){
                    if (postfix[j]==null){
                        postfix[j]=number;
                        number="";
                        elementsQuantity++;
                        break;
                    }
                }
                almacenarSignos.apilar(equation.charAt(i));
            } else if ((equation.charAt(i)==47)||(equation.charAt(i)==42)){
                for (int j=0; j<postfix.length; j++){
                    if (postfix[j]==null){
                        postfix[j]=number;
                        number="";
                        elementsQuantity++;
                        break;
                    }
                }
                almacenarSignos.apilar(equation.charAt(i));
            } else if (equation.charAt(i) == 61){
                for (int j=0; j<postfix.length; j++){
                    if (postfix[j]==null){
                        postfix[j]=number;
                        number="";
                        elementsQuantity++;
                        break;
                    }
                }
                while (!almacenarSignos.esVacia()){
                    try {
                        for (int k=0; k<postfix.length; k++){
                            if (postfix[k]==null){
                                postfix[k]= ""+almacenarSignos.verTope();
                                elementsQuantity++;
                                break;
                            }
                        }
                        almacenarSignos.desapilar();
                    } catch (ExcepcionPilaVacia excepcionPilaVacia) {
                        excepcionPilaVacia.printStackTrace();
                    }
                }
            } else {
                for (int j=0; j<postfix.length; j++){
                    if (postfix[j]==null){
                        postfix[j]=number;
                        number="";
                        elementsQuantity++;
                        break;
                    }
                }
                while (!almacenarSignos.esVacia()){
                    try {
                        for (int k=0; k<postfix.length; k++){
                            if (postfix[k]==null){
                                postfix[k]= ""+almacenarSignos.verTope();
                                elementsQuantity++;
                                break;
                            }
                        }
                        almacenarSignos.desapilar();
                    } catch (ExcepcionPilaVacia excepcionPilaVacia) {
                        excepcionPilaVacia.printStackTrace();
                    }
                }
                almacenarSignos.apilar(equation.charAt(i));
            }
        }
        equationElements = new String[elementsQuantity];
        System.arraycopy(postfix, 0, equationElements, 0, equationElements.length);
        postfix = equationElements;
    }

    /**
     * Devuelve la ecuacion en orden postfijo
     * @return el arreglo que representa la ecuacion en orden postfijo
     */
    public String[] getPostfix(){
        return postfix;
    }

}
