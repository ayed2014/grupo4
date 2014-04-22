package tp7;

/**
 * Created by Fran on 15/04/14.
 */
public class BinTreeTester {
    public static void main(String[] args) {
        BinTreeApi treeApi = new BinTreeApi();

        BinTree firstTree = new BinTree(1, new BinTree(2, new BinTree(1), new BinTree(1)), new BinTree(3));
        BinTree secondTree = new BinTree(1, new BinTree(2, new BinTree(4), new BinTree(5)), new BinTree(3));
        BinTree thirdTree = new BinTree(1, new BinTree(2, new BinTree(4), new BinTree(6)), new BinTree(3));
        BinTree fourthTree = new BinTree(1, new BinTree(2, new BinTree(4), new BinTree(5)), new BinTree(3, new BinTree(6), new BinTree(7)));
        BinTree fifthTree = new BinTree();
        BinTree sixthTree = new BinTree(3, new BinTree(2), new BinTree(1));
        BinTree seventhTree = new BinTree(2, new BinTree(4), new BinTree(5));

        System.out.println(treeApi.weight(firstTree));
        System.out.println(treeApi.leafsAmount(firstTree));
        System.out.println(treeApi.sumIntegersInTree(firstTree));
        System.out.println(treeApi.sumThreeMultiples(firstTree));
        System.out.println("Arboles iguales: " +treeApi.equalTrees(firstTree, secondTree));
        System.out.println("Arboles isomorficos: " +treeApi.isomorphicTreesAlt(firstTree, thirdTree));
        //System.out.println("Arbol completo: " +treeApi.completeTree(fourthTree));
        //System.out.println("Arbol estable: " +treeApi.isStable(fifthTree) +" y " +treeApi.isStable(sixthTree));
        //System.out.println("Arbol dentro de otro: " +treeApi.insideAnother(firstTree, seventhTree));
        treeApi.showFrontier(firstTree);
        System.out.println();
        treeApi.printPreOrder(firstTree);
        System.out.println();
        //treeApi.printByLevel(firstTree);
        treeApi.printInOrder(firstTree);
        System.out.println();
        treeApi.printPostOrder(firstTree);

        System.out.println("\n\n"+treeApi.objectAmount(firstTree, 1));
        System.out.println("\n\n"+treeApi.height(firstTree));
        System.out.println("\n\n"+treeApi.border(firstTree,2));
        System.out.println();
    }
}
