package TP4.Ejercicio1;

import TP4.DynamicQueue;
import TP4.Queue;
import TP4.StaticQueue;
import TP4.ExcepcionPilaVacia;
import TP4.Pila;
import TP4.PilaD;
import TP4.PilaE;

public class Palindrome {
    private Queue c;
    private Pila p;
    private boolean palindrome;
    private String word;

    public Palindrome(String word, boolean dynaOrStat){
        if (dynaOrStat){
            c = new DynamicQueue();
            p = new PilaD();
        } else {
            c = new StaticQueue();
            p = new PilaE();
        }
        this.word = word;
        pushAndEnqueue();
        analise();
    }

    private void pushAndEnqueue(){
        for (int i = 0; i<word.length(); i++){
            c.enqueue(word.charAt(i));
            p.apilar(word.charAt(i));
        }
    }

    private void analise(){
        for (int j = 0; j<(word.length()/2); j++){
            try {
                Character ofQueue = (Character)c.dequeue();
                Character ofStack = (Character)p.verTope();
                p.desapilar();
                if (!ofQueue.equals(ofStack)){
                    palindrome = false;
                    return;
                }
            } catch (ExcepcionPilaVacia excepcionPilaVacia) {
                excepcionPilaVacia.printStackTrace();
            }
        }
        palindrome = true;
    }

    public boolean isPalindrome(){
        return palindrome;
    }

}
