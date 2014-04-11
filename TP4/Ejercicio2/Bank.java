package TP4.Ejercicio2;

import TP4.DynamicQueue;

/**
 * b)	Cada cajero tiene una cola de espera distinta. Si un cliente entra en el banco y uno o
 *      más cajeros están libres sin cola de espera, entonces la elección del cajero es
 *      aleatoria, teniendo cada cajero la misma probabilidad de ser escogido. En el caso de
 *      que todos los cajeros estén ocupados, los clientes se incorporan a la cola más corta
 *      Si dos o más delas colas más cortas tienen el mismo número de clientes, el cliente se
 *      incorpora a una de estas colas aleatoriamente, teniendo cada cola la misma
 *      probabilidad de ser elegida.
 */
public class Bank {
    private Cashier c1;
    private Cashier c2;
    private Cashier c3;
    private DynamicQueue waitLine;
    private int clientsAttended;
    private float c1TimeAfterClose;
    private float c2TimeAfterClose;
    private float c3TimeAfterClose;



    public Bank(){
        c1 = new Cashier();
        c2 = new Cashier();
        c3 = new Cashier();
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
               int random = 0;
               Client c = (Client) waitLine.dequeue();
               getClientToCashier(c,random);
            }
            int i1 = c1.getLenght();
            int i2 = c1.getLenght();
            int i3 = c1.getLenght();
            if(i1 < i2 && i1 < i3 && !(i2 == i3)){
                Client a1 = (Client) waitLine.dequeue();
                c1.newClient(a1);
            } else if(i2 < i1 && i2 < i3 && !(i1 == i3)){
                Client a1 = (Client) waitLine.dequeue();
                c2.newClient(a1);
            } else if(i3 < i1 && i3 < i2 && !(i1 == i2)){
                Client a1 = (Client) waitLine.dequeue();
                c3.newClient(a1);
            } else if(i1 > i2 && i1 > i3 &&(i2 == i3) ){
                Client a1 = (Client) waitLine.dequeue();
                int rand = (int) (Math.random()*3+2);
                getClientToCashier(a1, rand);
            } else if(i2 > i3 && i1 > i1 &&(i1 == i3) ){
                Client a1 = (Client) waitLine.dequeue();
                int rand = (int) (Math.random()*5+4);
                getClientToCashier(a1, rand);
            }  else if(i3 > i2 && i3 > i1 &&(i2 == i1) ){
                Client a1 = (Client) waitLine.dequeue();
                int rand = (int) (Math.random()*2+1);
                getClientToCashier(a1, rand);
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
        for(int j = 0; j < c1.getLenght(); j++){
            c1.dismissClient();
            clientsAttended++;
            c1TimeAfterClose++;
        }
        for(int j = 0; j < c2.getLenght(); j++){
            c2.dismissClient();
            clientsAttended++;
            c2TimeAfterClose++;
        }
        for(int j = 0; j < c3.getLenght(); j++){
            c3.dismissClient();
            clientsAttended++;
            c3TimeAfterClose++;
        }

    }

    private void getClientToCashier(Client c, int i){
         switch (i){
             case 1 : c1.newClient(c);
                 break;
             case 2 : c2.newClient(c);
                 break;
             case 3 : c3.newClient(c);
                 break;
             case 4 : c1.newClient(c);
                 break;
             case 5 : c3.newClient(c);
                 break;
         }
    }

    public int getClientsAttended(){
        return clientsAttended;
    }

    public float getC1TimeAfterClose(){
        float i = (c1TimeAfterClose*30)/3600;
        return i;
    }
    public float getC2TimeAfterClose(){
        float i = (c2TimeAfterClose*30)/3600;
        return i;
    }
    public float getC3TimeAfterClose(){
        float i = (c3TimeAfterClose*30)/3600;
        return i;
    }




}
