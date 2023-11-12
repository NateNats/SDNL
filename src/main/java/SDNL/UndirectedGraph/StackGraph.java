package SDNL.UndirectedGraph;
import java.util.Stack;

public class StackGraph {
    Stack<Character> stack;

    public StackGraph() {
        this.stack = new Stack<>();
    }

    public void push(char value) {
        stack.push(value);
    }

    public char pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

