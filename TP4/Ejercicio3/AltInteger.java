package TP4.Ejercicio3;

public class AltInteger implements Priorizable {
    private Integer value;

    public AltInteger(Integer value) {
        this.value = value;
    }

    @Override
    public int getPriority(Object x) {
        AltInteger toAnalise = (AltInteger) x;
        return (toAnalise.getValue() < value) ? 1 : ((toAnalise.getValue() == value) ? 0 : -1);
    }

    public int getValue(){
        return value;
    }
}
