package TP4.Ejercicio2;

import TP4.DynamicQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Agustin
 * Date: 07/04/14
 * Time: 22:05
 * To change this template use File | Settings | File Templates.
 */
public class Cashier {

    private DynamicQueue clients;
    private int cash;

    public Cashier(){
        clients = new DynamicQueue();
        cash = 0;
    }

    public void newClient(Client x){
      clients.enqueue(x);
    }

    public void dismissClient(){
        clients.dequeue();
    }

    public int getCash(){
        return cash;
    }

    public boolean isEmpty(){
        return  clients.isEmpty();
    }

    public int getLenght(){
        return clients.lenght();
    }
}
