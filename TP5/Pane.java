package TP5;

public class Pane {
    private int passengerTime;
    private int passengersAmount;
    private int idleTime;
    private float money;
    private DynamicQueue passengersQueue;

    public Pane() {
        passengerTime = 0;
        passengersAmount = 0;
        idleTime = 0;
        money = 0;
        passengersQueue = new DynamicQueue();
    }

    public void passengerArrived(int time) {
        passengersQueue.enqueue(new Passenger(time));
    }

    public void attendPassenger(int attendedTime) {
        if (!passengersQueue.isEmpty()) {
            Passenger temp = (Passenger) passengersQueue.dequeue();
            temp.setTicketTime(attendedTime);
            passengersAmount += 1;
            passengerTime += temp.getWaitingTime();
            money += 0.7;
        } else {
            setIdleTime();
        }
    }

    public void setIdleTime() {
        idleTime += 1;
    }

    public long averagePassengersTime() {
        return (passengerTime / passengersAmount);
    }

    public float getMoney() {
        return money;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public boolean isEmpty(){
        return passengersQueue.isEmpty();
    }
}
