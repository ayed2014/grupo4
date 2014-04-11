package TP4.Ejercicio2;

import TP4.DynamicQueue;

/** a)	Se forma una única cola de clientes. Si uno o más cajeros están desocupados, el
 *      primer cliente de la cola es atendido. Si más de un cajero está libre, la elección del
 *      cajero es aleatoria, teniendo cada cajero la misma probabilidad de ser escogido.
 * */

public class Bank2 {
    private Cashier2 c1;
    private Cashier2 c2;
    private Cashier2 c3;
    private DynamicQueue waitLine;
    private int clientsAttended;
    private float timeAfterClose;




    public Bank2(){
        c1 = new Cashier2();
        c2 = new Cashier2();
        c3 = new Cashier2();
        waitLine = new DynamicQueue();
        clientsAttended = 0;

    }

    public void start(){
        for(int j = 0; j < 15; j++){
            Client c = new Client();
            waitLine.enqueue(c);
        }
         int t1 = 0;
         int t2 = 0;
         int t3 = 0;
         int t4 = 0;
        for(int i = 0; i < 600; i++){

            if(t4 == 3){
                Client c = new Client();
                waitLine.enqueue(c);
                t4 = 0;
            }else{
                t4++;
            }

            if(c1.isEmpty() && c2.isEmpty()&& c3.isEmpty()){
                int random = (int) (Math.random()*3+1);;
                Client c = (Client) waitLine.dequeue();
                getClientToCashier(c,random);
            }else if(c1.isEmpty() && !c2.isEmpty()&& !c3.isEmpty()){
                Client c = (Client) waitLine.dequeue();
                c1.addClient(c);
            } else if(!c1.isEmpty() && c2.isEmpty()&& !c3.isEmpty()){
                Client c = (Client) waitLine.dequeue();
                c2.addClient(c);
            } else if(!c1.isEmpty() && !c2.isEmpty()&& c3.isEmpty()){
                Client c = (Client) waitLine.dequeue();
                c3.addClient(c);
            } else if(c1.isEmpty() && c2.isEmpty()&& !c3.isEmpty()){
                int random = (int) (Math.random()*2+1);
                Client c = (Client) waitLine.dequeue();
                getClientToCashier(c,random);
            } else if(c1.isEmpty() && !c2.isEmpty()&& c3.isEmpty()){
                int random = (int) (Math.random()*5+4);
                Client c = (Client) waitLine.dequeue();
                getClientToCashier(c,random);
            }else if(!c1.isEmpty() && c2.isEmpty()&& c3.isEmpty()){
                int random = (int) (Math.random()*3+2);
                Client c = (Client) waitLine.dequeue();
                getClientToCashier(c,random);
            }
            int random = (int) (Math.random()*2+1);
            if(random == 1){
                c1.dismissClient();
                t1 = 0;
                clientsAttended++;
            } else if(t1 == 3){
                c1.dismissClient();
                t1 = 0;
                clientsAttended++;
            } else{
                t1++;
            }

            if(random == 1){
                c2.dismissClient();
                t2 = 0;
                clientsAttended++;
            } else if(t2 == 4){
                c2.dismissClient();
                t2 = 0;
                clientsAttended++;
            } else{
                t2++;
            }

            if(random == 1){
                c3.dismissClient();
                t3 = 0;
                clientsAttended++;
            } else if(t3 == 5){
                c1.dismissClient();
                t3 = 0;
                clientsAttended++;
            } else{
                t3++;
            }


        }

       for(int i = 0; i < waitLine.lenght(); i++){
           waitLine.dequeue();
           clientsAttended++;
           timeAfterClose++;

       }

    }

    private void getClientToCashier(Client c, int i){
        switch (i){
            case 1 : c1.addClient(c);
                break;
            case 2 : c2.addClient(c);
                break;
            case 3 : c3.addClient(c);
                break;
            case 4 : c1.addClient(c);
                break;
            case 5 : c3.addClient(c);
                    break;
        }
    }

    public int getClientsAttended(){
        return clientsAttended;
    }

    public float getTimeAfterClose(){
        float i = (timeAfterClose*30)/3600;
        return i;
    }
}
