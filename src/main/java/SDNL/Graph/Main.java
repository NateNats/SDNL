package SDNL.Graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A');   //index 0
        graph.addVertex('B');   //index 1
        graph.addVertex('C');   //index 2
        graph.addVertex('D');   //index 3
        graph.addVertex('E');   //index 4
        graph.show();
        System.out.println(graph);
    }
}
