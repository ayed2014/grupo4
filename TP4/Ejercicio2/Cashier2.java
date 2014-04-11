package TP4.Ejercicio2;

/**
 * Created with IntelliJ IDEA.
 * User: Agustin
 * Date: 10/04/14
 * Time: 18:32
 * To change this template use File | Settings | File Templates.
 */
public class Cashier2 {

    Client[] client;

    public Cashier2(){
        client = new Client[1];
    }

    public void addClient(Client c){
       client[0] = c;
    }

    public void dismissClient(){
        client[0] = null;
    }

    public boolean isEmpty(){
        return client[0] == null;
    }
}
