package TP4.Ejercicio2;

/**
 * Created with IntelliJ IDEA.
 * User: Agustin
 * Date: 10/04/14
 * Time: 19:01
 * To change this template use File | Settings | File Templates.
 */
public class Tester {

    public static void main(String[] args) {

        Bank b = new Bank();
        Bank2 b2 = new Bank2();

        b.start();
        b2.start();

        int i = b.getClientsAttended();
        int i2 = b2.getClientsAttended();

        float c1 = b.getC1TimeAfterClose();
        float c2 = b.getC2TimeAfterClose();
        float c3 = b.getC3TimeAfterClose();
        float b2Time = b2.getTimeAfterClose();

        System.out.println("En el primer enfoque hay una sola cola de espera, si los cajeros estan libres la eleccion es" +
                " aleatoria. Si uno solo esta libre el cliente sera atendido por esa caja. Si dos cajas estan libres se " +
                " hara una eleccion aleatoria entre esas dos." +
                " En esta simulacion se han atendido a" + " " + i2 + " " +"clientes, luego de haber cerrado el acceso al" +
                " banco se tardo en atender a los clientes dentro unas" + " " + b2Time + " " + "horas.");

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("En el segundo enfoque hay una cola de espera y cada caja tiene su propia cola de espera. Si " +
                " los cajeros estan libres la eleccion es aleatoria. Si uno solo esta libre el cliente sera atendido por" +
                " esa caja. Si dos cajas estan libres se  hara una eleccion aleatoria entre esas dos." +
                " En esta simulacion se han atendido a" + " " + i + " " +"clientes, luego de haber cerrado las puertas del" +
                " banco la caja uno tardo" + " " + c1 + " " + "en atender a los clientes en su cola, la caja  dos tardo"
                  + " " + c2 + " " +"En atender a los clientes es su cola y la caja tres tardo" + " " + c3 + " " + "en " +
                " atender a sus clientes");
    }

}
