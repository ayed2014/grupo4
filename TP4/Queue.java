package TP4;

/**
 * Created by cristian on 28/03/14.
 */
public interface Queue {
    public void enqueue(Object x);
    public Object dequeue();
    public boolean isEmpty();
    public int lenght();
}
