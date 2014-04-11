package TP4;

import TP3.Ejercicio1.Nodo;

public class DynamicQueue implements Queue {
    private int amount;
    private Nodo first;
    private Nodo last;

    public DynamicQueue() {
        amount = 0;
        first = null;
        last = null;
    }

    @Override
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

    @Override
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

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int lenght() {
        return amount;
    }
}
