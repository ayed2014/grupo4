package TP4.Ejercicio3;

import TP3.Ejercicio1.Nodo;

public class PriorityQueue {
    private int amount;
    private Nodo first;
    private Nodo last;

    public PriorityQueue() {
        amount = 0;
        first = null;
        last = null;
    }

    public void enqueueAlt(Priorizable x) {
        Nodo toAdd = new Nodo(x, null);
        amount++;
        if (isEmpty()) {
            first = toAdd;
            last = toAdd;
        } else if (first.equals(last)) {
            if ((x.getPriority(first.getElemento()) <= 0)) {
                first.setNodo(toAdd);
                last = toAdd;
            } else {
                toAdd.setNodo(first);
                first = toAdd;
            }
        } else {
            Nodo temp = first;
            while (temp != last) {
                if ((x.getPriority(temp.getElemento()) <= 0) && (x.getPriority(temp.getReferencia().getElemento()) > 0)) {
                    toAdd.setNodo(temp.getReferencia());
                    temp.setNodo(toAdd);
                    break;
                } else if ((x.getPriority(temp.getReferencia().getElemento()) <= 0) && (temp.getReferencia().getReferencia() == null)) {
                    last.setNodo(toAdd);
                    last = toAdd;
                    break;
                }
                temp = temp.getReferencia();
            }
        }
    }

    public void enqueue(Object x) {
        Nodo toAdd = new Nodo(x, null);
        amount++;
        if (isEmpty()) {
            first = toAdd;
            last = toAdd;
        } else {
            last.setNodo(toAdd);
            last = toAdd;
        }
    }

    public Object dequeue() {
        if (first != null) {
            Object temp = first.getElemento();
            amount--;
            first = first.getReferencia();
            return temp;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int lenght() {
        return amount;
    }

}
