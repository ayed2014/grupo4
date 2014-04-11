package TP5;

import java.text.DecimalFormat;

public class PaneSimulation {
    private List metrovias;

    public PaneSimulation(int panes){
        metrovias = new StaticList();
        for (int i = 0; i<panes; i++){
            metrovias.insertAfter(new Pane());
        }
        simulate(panes);
        printResults(panes);
    }

    private void simulate(int num){
        for (int j = 0; j<5757; j++){
                for (int p = 0; p<5; p++){
                    int random = 1 + (int)(Math.random() * ((num - 1) + 1));
                    metrovias.goTo(random-1);
                    Pane temp = (Pane)metrovias.see();
                    temp.passengerArrived(j);
                }
                for (int o = 0; o<num; o++){
                    int probability = 1 + (int)(Math.random() * ((100 - 1) + 1));
                    metrovias.goTo(o);
                    Pane temp = (Pane)metrovias.see();
                    if (probability<=30){
                        temp.attendPassenger(j);
                    } else {
                        temp.setIdleTime();
                    }
                }
        }
        for (int q = 5757; q<5760; q++){
            for (int p = 0; p<5; p++){
                int random = 1 + (int)(Math.random() * ((num - 1) + 1));
                metrovias.goTo(random-1);
                Pane temp = (Pane)metrovias.see();
                temp.passengerArrived(q);
            }
            for (int u = 0; u<num; u++){
                metrovias.goTo(u);
                Pane temp = (Pane)metrovias.see();
                while (!temp.isEmpty()){
                temp.attendPassenger(q);
                }
            }
        }
    }

    private void printResults(int num){
        for (int k = 1; k<= num; k++){
            metrovias.goTo(k-1);
            Pane temp = (Pane)metrovias.see();
            System.out.println("Ventanilla: " +k);
            System.out.println("Tiempo medio de espera de los pasajeros: "
                    +(temp.averagePassengersTime()*10) +" segundos");
            System.out.println("Recaudacion: $ " +new DecimalFormat("#.0").format(temp.getMoney()));
            System.out.println("Tiempo ocioso: " +(temp.getIdleTime()*10) +" segundos \n");
        }
    }

}
