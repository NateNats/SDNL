package SDNL.TreeDelete;

public class Main {
    public static void main(String[] args) {
        Node node = new Node(50, null);
        Tree p = new Tree(node);

        int[] arr = {30, 65, 45, 62, 35, 64, 63, 48};

        for (int i = 0; i < arr.length; i++) {
            p.insertNode(arr[i]);
        }
//        p.printStructureV1(node, arr.length);
//
//        p.cetak();
        p.delete(30);
        p.delete(65);
        p.cetak();

//        p.delete(30);
//        Node n = p.find(45);
//        System.out.println("Nilai node: " + n.getData());
//        System.out.println("Nilai parent: " + n.getParent().getData());
//        System.out.println("child kiri: " + ((n.getLeftNode() == null) ? "tidak ada": n.getLeftNode().getData()));
//        System.out.println("Child kanan: " + ((n.getRightNode() == null) ? "tidak ada": n.getRightNode().getData()));
    }
}
