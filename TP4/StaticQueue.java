package TP4;

public class StaticQueue implements Queue {
    private int first;
    private int last;
    private int amount;
    private int size;
    private Object[] objectsInQueue;

    public StaticQueue() {
        first = 0;
        last = 0;
        amount = 0;
        objectsInQueue = new Object[5];
        size = objectsInQueue.length;
    }

    @Override
    public void enqueue(Object x) {
        if (!isFull()) {
            objectsInQueue[last] = x;
            last = increment(last);
            amount++;
        } else {
            incrementQueue();
            enqueue(x);
        }
    }

    @Override
    public Object dequeue() {
        if (!isEmpty()) {
            Object temp = objectsInQueue[first];
            first = increment(first);
            amount--;
            return temp;
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return amount == 0;
    }

    @Override
    public int lenght() {
        return amount;
    }

    public int increment(int i) {
        if (i == size - 1) i = 0;
        else i++;
        return i;
    }

    private void incrementQueue() {
        Object[] aux = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            aux[i] = dequeue();
        }
        size = aux.length;
        objectsInQueue = aux;
        first = 0;
        last = size - 1;
        amount = last;
    }

    public boolean isFull() {
        return (amount == size);
    }
}
