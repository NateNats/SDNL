package SDNL.TreeExpression;

public class Main {
    public static void main(String[] args) {
        char[] insert = {'A', '+', 'B'};

        Infix fix = new Infix(insert);
        Tree pohon = new Tree();
        pohon.setRootTree(fix.buatPohon());
        pohon.inOrderTraversal();
    }
}
