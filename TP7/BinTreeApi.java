package tp7;

import queu.DQueue;

import java.util.ArrayList;

/**
 * Created by Fran on 15/04/14.
 */
public class BinTreeApi {
    public int weight(BinTree a) {
        if (a.isEmpty()) {
            return 0;
        } else {
            return 1 + weight(a.getLeft()) + weight(a.getRight());
        }
    }

    public int leafsAmount(BinTree a) {
        if (a.isEmpty()) {
            return 0;
        } else if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            return 1;
        } else {
            return leafsAmount(a.getLeft()) + leafsAmount(a.getRight());
        }
    }

    public int objectAmount(BinTree a, Object o) {
        int amount = 0;

         if (a.getRoot().equals(o)){
            amount++;
        }
        if (!a.getRight().isEmpty()){
            amount+=objectAmount(a.getRight(),o);
        }
        if (!a.getLeft().isEmpty()){
            amount+=objectAmount(a.getLeft(),o);
        }
        return amount;



    }

    public int height(BinTree a) {
        if (a.isEmpty()) {
            return 0;
        } else {
            int heightLeft = height(a.getLeft());
            int heightRight = height(a.getRight());
            if (heightLeft > heightRight)
                return heightLeft + 1;
            else
                return heightRight + 1;
        }
    }

    //PROBAR
    public int objectAmountInLevel(BinTree a, Object o, int level, int currentLevel) {
        int amount = 0;
        if (a.isEmpty()) {
            return 0;
        }
        if (currentLevel == level) {
            return 1;
        } else {
            Object left = objectAmountInLevel(a.getLeft(), o, level, currentLevel + 1);
            Object right = objectAmountInLevel(a.getRight(), o, level, currentLevel + 1);

            if (left == o && right == o) {
                amount += 2;
            } else if (left == o || right == o) {
                amount += 1;
            }
        }
        return amount;
    }

    public int sumIntegersInTree(BinTree a) {
        if (a.isEmpty()) {
            return 0;
        } else if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            return (Integer) a.getRoot();
        } else {
            return sumIntegersInTree(a.getLeft()) + sumIntegersInTree(a.getRight());
        }
    }

    public int sumThreeMultiples(BinTree a) {
        if (a.isEmpty()) {
            return 0;
        } else if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            if ((Integer) a.getRoot() % 3 == 0) {
                return (Integer) a.getRoot();
            } else {
                return 0;
            }
        } else {
            return sumThreeMultiples(a.getLeft()) + sumThreeMultiples(a.getRight());
        }
    }

    public boolean equalTrees(BinTree a, BinTree b) {
        if (equalsRoots(a, b) && equalsShape(a, b)) {
            return true;
        }
        return false;
    }

    private boolean equalsShape(BinTree a, BinTree b) {
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        } else if ((a.isEmpty() && !b.isEmpty()) || (!a.isEmpty() && b.isEmpty())) {
            return false;
        } else {
            return equalsShape(a.getLeft(), b.getLeft()) && equalTrees(a.getRight(), b.getRight());
        }
    }

    private boolean equalsRoots(BinTree a, BinTree b) {
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        } else if (!a.getRoot().equals(b.getRoot())) {
            return false;
        } else {
            return equalsRoots(a.getLeft(), b.getLeft()) && equalTrees(a.getRight(), b.getRight());
        }
    }

    public boolean isomorphicTrees(BinTree a, BinTree b) {
        if (a.isEmpty() && b.isEmpty()) {
            return false;
        } else if ((a.isEmpty() && !b.isEmpty()) || (!a.isEmpty() && b.isEmpty())) {
            return false;
        } else if (a.getRoot() != b.getRoot()) {
            return true;
        } else {
            return isomorphicTrees(a.getLeft(), a.getRight()) && isomorphicTrees(a.getRight(), b.getRight());
        }
    }

    public boolean isomorphicTreesAlt(BinTree a, BinTree b) {
        if (equalsShape(a, b) && !equalsRoots(a, b)) {
            return true;
        }
        return false;
    }

    public boolean completeTree(BinTree a) {
        if (a.isEmpty()) {
            return false;
        } else if ((a.getLeft().isEmpty() && !a.getRight().isEmpty()) || (!a.getLeft().isEmpty() && a.getRight().isEmpty())) {
            return false;
        } else if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            return true;
        } else {
            return completeTree(a.getLeft()) && completeTree(a.getRight());
        }
    }

    public boolean isStable(BinTree a) {
        if (a.isEmpty()) {
            return true;
        } else if (a.getLeft() == null && a.getRight() == null) {
            return true;
        } else if ((a.getLeft().getRight() == null && a.getLeft().getLeft() == null) && (a.getRight().getRight() == null && a.getRight().getLeft() == null)) {
            if ((Integer) a.getRoot() > (Integer) a.getRight().getRoot() && (Integer) a.getRoot() > (Integer) a.getLeft().getRoot()) {
                return true;
            } else {
                return false;
            }
        } else {
            return isStable(a.getLeft()) && isStable(a.getRight());
        }
    }

    public boolean insideAnother(BinTree a, BinTree b) {
        if (equalTrees(a, b)) {
            return true;
        }
        return insideAnother(a.getRight(), b) || insideAnother(a.getLeft(), b);
    }

    public void showFrontier(BinTree a) {
        if (a.isEmpty()) {
            System.out.println("Arbol vacio");
        } else if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            System.out.println(a.getRoot());
        } else {
            showFrontier(a.getLeft());
            showFrontier(a.getRight());
        }
    }

    private ArrayList<Object> getFrontier(BinTree a) {
        ArrayList<Object> array = new ArrayList<Object>();
        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            array.add(a.getRoot());
            return array;
        } else {
            if (!a.getLeft().isEmpty()){
        array =getFrontier(a.getLeft());
            }
            if (a.getRight().isEmpty()){
        ArrayList<Object> array2=getFrontier(a.getRight());
            for(int i=0;i<array2.size();i++){
                array.add(array2.get(i));
            }
            }
        }
        return array;
    }

    public ArrayList<Object> border(BinTree a, Object object) {
        ArrayList<Object> array=new ArrayList<Object>();
        if (a.isEmpty()) {
            return null;
        }

        if (a.getRoot().equals(object)) {
            return getFrontier(a);
        } else {
            if (!a.getLeft().isEmpty()){
           array= border(a.getLeft(), object);
            }if (!a.getRight().isEmpty()){
            ArrayList<Object> array2=border(a.getRight(), object);
            if (!array2.isEmpty()){
            for(int i=0;i<array2.size();i++){
                array.add(array2.get(i));
            }
            }
        }
        }
        return array;

    }

    public void printPreOrder(BinTree a) {
        if (a.isEmpty()) {
            return;
        } else {
            System.out.print(a.getRoot() + "   ");
            printPreOrder(a.getLeft());
            printPreOrder(a.getRight());
        }
    }

    public void printInOrder(BinTree a) {
        if (a.isEmpty()) {
            return;
        } else {
            printInOrder(a.getLeft());
            System.out.print(a.getRoot() + "   ");
            printInOrder(a.getRight());
        }
    }

    public void printPostOrder(BinTree a) {
        if (a.isEmpty()) {
            return;
        } else {
            printPostOrder(a.getLeft());
            printPostOrder(a.getRight());
            System.out.print(a.getRoot() + "   ");
        }
    }

    public void printByLevel(BinTree a) {
        queu.Queue level = new DQueue();
        level.enqueue(a);
        while (!level.isEmpty()) {
            BinTree node = (BinTree) level.queue();
            if (node.getRoot() != null) {
                System.out.print(node.getRoot() + "  ");
            }
            if (node.getLeft() != null) level.enqueue(node.getLeft());
            if (node.getRight() != null) level.enqueue(node.getRight());
        }
    }
}
