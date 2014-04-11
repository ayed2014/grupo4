package TP4.Ejercicio3;

public class PriorityTester {
    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();

        q.enqueueAlt(new AltInteger(3));
        q.enqueueAlt(new AltInteger(1));
        q.enqueueAlt(new AltInteger(3));
        q.enqueueAlt(new AltInteger(2));
        q.enqueueAlt(new AltInteger(1));

        while (!q.isEmpty()){
            AltInteger toPrint = (AltInteger) q.dequeue();
            System.out.println(toPrint.getValue());
        }
    }
}
