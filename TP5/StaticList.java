package TP5;

public class StaticList implements List {
    private int current;
    private int amount;
    private Object[] objectsInList;

    public StaticList() {
        current = -1;
        amount = 0;
        objectsInList = new Object[10];
    }

    @Override
    public Object see() {
        if (!isEmpty()) return objectsInList[current];
        else return null;
    }

    @Override
    public void empty() {
        current = -1;
        amount = 0;
        objectsInList = new Object[objectsInList.length];
    }

    @Override
    public boolean isEmpty() {
        return amount == 0;
    }

    @Override
    public void insertBefore(Object o) {
        if (isEmpty()) {
            current++;
            objectsInList[current] = o;
            amount++;
        }else if(current == amount-1 && objectsInList[objectsInList.length - 1] == null){
            objectsInList[amount] = objectsInList[current];
            objectsInList[current] = o;
            amount++;
        } else {
            if (objectsInList[objectsInList.length - 1] == null) {
                for (int i = amount; i > current; i--) {
                    objectsInList[i] = objectsInList[i - 1];
                }
                objectsInList[current] = o;
                amount++;
            } else {
                incrementList();
                insertBefore(o);
            }
        }
    }

    @Override
    public void insertAfter(Object o) {
        if (isEmpty()) {
            current++;
            objectsInList[current] = o;
            amount++;
        } else if (current == amount-1 && objectsInList[objectsInList.length - 1] == null) {
            current++;
            objectsInList[current] = o;
            amount++;
        } else {
            if (objectsInList[objectsInList.length - 1] == null) {
                for (int i = amount; i > current + 1; i--) {
                    objectsInList[i] = objectsInList[i-1];
                }
                current++;
                objectsInList[current] = o;
                amount++;
            } else {
                incrementList();
                insertBefore(o);
            }
        }
    }

    @Override
    public void next() {
        if (objectsInList[current + 1] != null) current++;
        else System.out.println("Can't go further");
    }

    @Override
    public void before() {
        if (current != 0) current--;
        else System.out.println("Can't go further");
    }

    @Override
    public void goTo(int x) {
        if (objectsInList[x] != null) current = x;
        else System.out.println("Invalid number");
    }

    @Override
    public void eliminate() {
        if (!isEmpty()) {
            for(int pos = current; pos < amount-1; pos++){
                objectsInList[pos] = objectsInList[pos+1];
            }
            amount--;
            current--;
        } else {
            System.out.println("Empty List");
        }
    }

    @Override
    public void modify(Object o) {
        if (!isEmpty()){
            objectsInList[current] = o;
        } else {
            System.out.println("Empty List");
        }
    }

    private void incrementList() {
        Object[] aux = new Object[objectsInList.length + 5];
        for (int i = 0; i < objectsInList.length; i++) {
            aux[i] = objectsInList[i];
        }
        objectsInList = aux;
    }
}
