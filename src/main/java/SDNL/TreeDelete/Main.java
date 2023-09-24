package SDNL.TreeDelete;

public class Main {
    public static void main(String[] args) {
        Node node = new Node(50, null);
        Tree p = new Tree(node);

        int[] arr = {30, 65, 45, 62, 35, 64, 63, 48};

        for (int i = 0; i < arr.length; i++) {
            p.insertNode(arr[i]);
        }

        p.delete(30);
        p.preOrderTraversal();

        p.delete(65);
        System.out.println();
        p.preOrderTraversal();
    }
}
