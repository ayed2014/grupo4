package TP5;

public interface List {
    public Object see();
    public void empty();
    public boolean isEmpty();
    public void insertBefore(Object o);
    public void insertAfter(Object o);
    public void next();
    public void before();
    public void goTo(int x);
    public void eliminate();
    public void modify(Object o);
}
