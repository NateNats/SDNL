package SDNL.TreeDelete;

public class Main2 {
    public static void main(String[] args) {
        Node n = new Node(10, null);
        n.insert(8);
        n.insert(12);

        System.out.println(n.getData());
        System.out.println(n.getLeftNode().getData());
        System.out.println(n.getRightNode().getData());
    }
}
