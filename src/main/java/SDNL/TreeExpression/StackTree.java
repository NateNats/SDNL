package SDNL.TreeExpression;

public class StackTree {
    private ListTree stackListTree;
    private int front;

    public StackTree() {
        stackListTree = new ListTree();
        front = 0;
    }

    public void push(TreeNode node) {
        stackListTree.insertAtFront(node);
    }

    public TreeNode pop() {
        if (!isEmpty()) {
            return stackListTree.removeFromFront();
        }

        return null;
    }

    public boolean isEmpty() {
        return stackListTree.isEmpty();
    }

    public void print() {}
}
