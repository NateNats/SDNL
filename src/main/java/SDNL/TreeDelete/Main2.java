package SDNL.TreeDelete;

public class Main2 {
    public static void main(String[] args) {
        Node m = new Node (20, null);
        Node n = new Node(10, m);
        n.insert(8);
        n.insert(12);

        System.out.println(n.getParent().getData());
        System.out.println(n.getData());
        System.out.println(n.getLeftNode().getData());
        System.out.println(n.getRightNode().getData());
    }
}
