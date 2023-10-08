package SDNL.TreeExpression;

public class StackTree {
    private ListTree stackListTree;

    public StackTree() {
        stackListTree = new ListTree();
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
        return true;
    }

    public void print() {}
}
