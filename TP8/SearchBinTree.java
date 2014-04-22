package TP8;

public class SearchBinTree {
    private NodoDoble raiz;

    public SearchBinTree() {
        raiz = null;
    }

    public void add(Comparable x) throws RepeatedObjectException {
        raiz = add(raiz, x);
    }

    private NodoDoble add(NodoDoble node, Comparable x) throws RepeatedObjectException {
        if (node == null) {
            node = new NodoDoble();
            node.elemen = x;
        } else if (x.compareTo(node.elemen) == 0) {
            throw new RepeatedObjectException();
        } else if (x.compareTo(node.elemen) < 0)
            node.izq = add(node.izq, x);
        else
            node.der = add(node.der, x);
        return node;
    }

    public void eliminar(Comparable x) throws ObjectExistenceException {
        if (existe(x)) {
            raiz = eliminar(raiz, x);
        } else {
            throw new ObjectExistenceException();
        }
    }

    public Object getMin() throws EmptyTreeException {
        if (esVacio()) {
            throw new EmptyTreeException();
        } else {
            return getMin(raiz).elemen;
        }
    }

    public Object getMax() throws EmptyTreeException {
        if (esVacio()) {
            throw new EmptyTreeException();
        } else {
            return getMax(raiz).elemen;
        }
    }

    public Object buscar(Comparable x) throws ObjectExistenceException{
        if (existe(x)){
            return buscar(raiz, x).elemen;
        } else {
            throw new ObjectExistenceException();
        }
    }

    public boolean existe(Comparable x) {
        return existe(raiz, x);
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    private NodoDoble getMax(NodoDoble t) {
        if (t.der == null)
            return t;
        else
            return getMax(t.der);
    }

    private NodoDoble getMin(NodoDoble t) {
        if (t.izq == null)
            return t;
        else
            return getMin(t.izq);
    }

    private NodoDoble buscar(NodoDoble t, Comparable x) {
        if (x.compareTo(t.elemen) == 0)
            return t;
        else if (x.compareTo(t.elemen) < 0)
            return buscar(t.izq, x);
        else
            return buscar(t.der, x);
    }

    private boolean existe(NodoDoble t, Comparable x) {
        if (t == null)
            return false;
        if (x.compareTo(t.elemen) == 0)
            return true;
        else if (x.compareTo(t.elemen) < 0)
            return existe(t.izq, x);
        else
            return existe(t.der, x);
    }

    private NodoDoble eliminar(NodoDoble t, Comparable x) {
        if (x.compareTo(t.elemen) < 0)
            t.izq = eliminar(t.izq, x);
        else if (x.compareTo(t.elemen) > 0)
            t.der = eliminar(t.der, x);
        else if (t.izq != null && t.der != null) {
            t.elemen = getMin(t.der).elemen;
            t.der = eliminarMin(t.der);
        } else if (t.izq != null)
            t = t.izq;
        else
            t = t.der;
        return t;
    }

    private NodoDoble eliminarMin(NodoDoble t) {
        if (t.izq != null)
            t.izq = eliminarMin(t.izq);
        else
            t = t.der;
        return t;
    }

    public Object getRoot() {
        return raiz.elemen;
    }

    public SearchBinTree getLeft() {
        SearchBinTree left = new SearchBinTree();
        left.raiz = raiz.izq;
        return left;
    }

    public SearchBinTree getRight() {
        SearchBinTree right = new SearchBinTree();
        right.raiz = raiz.der;
        return right;
    }

    public boolean isEmpty() {
        return (raiz==null);
    }

}
