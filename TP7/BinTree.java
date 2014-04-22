package tp7;

/**
 * Created by Fran on 15/04/14.
 */
public class BinTree {
    private NodoDoble raiz;

    public BinTree() {
        raiz = null;
    }

    public BinTree(Object x){
        raiz = new NodoDoble();
        raiz.elemen = x;
        raiz.izq = null;
        raiz.der = null;
    }

    public BinTree(Object x, BinTree t1, BinTree t2){
        raiz = new NodoDoble();
        raiz.elemen = x;
        raiz.izq = t1.raiz;
        raiz.der = t2.raiz;
    }

    public boolean isEmpty() {
        return (raiz==null);
    }

    public Object getRoot() {
        return raiz.elemen;
    }

    public BinTree getLeft() {
        BinTree left = new BinTree();
        left.raiz = raiz.izq;
        return left;
    }

    public BinTree getRight() {
        BinTree right = new BinTree();
        right.raiz = raiz.der;
        return right;
    }
}
