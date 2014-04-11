package TP5;

public class Passenger {
    private int arrivedTime;
    private int ticketTime;

    public Passenger(int arrived){
        arrivedTime = arrived;
    }

    public void setTicketTime(int ticketBought){
        ticketTime = ticketBought;
    }

    public int getWaitingTime(){
        return (ticketTime-arrivedTime);
    }
}
