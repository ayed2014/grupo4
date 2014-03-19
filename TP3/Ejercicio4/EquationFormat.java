package TP3.Ejercicio4;

import TP3.Ejercicio1.ExcepcionPilaVacia;
import TP3.Ejercicio1.Pila;
import TP3.Ejercicio1.PilaE;

public class EquationFormat {

    private String[] postfix;
    private Pila almacenarSignos;

    public EquationFormat(String equation){
        postfix = new String[equation.length()];
        almacenarSignos = new PilaE();
        infixToPostfix(equation);
    }

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

    public String[] getPostfix(){
        return postfix;
    }




}
