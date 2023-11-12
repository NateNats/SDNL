package SDNL.coba;

public class Main {
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge('A', 'B', 1);
        graph.addEdge('A', 'C', 1);
        graph.addEdge('B', 'C', 1);
        graph.addEdge('B', 'D', 1);
        graph.addEdge('C', 'E', 1);
        graph.addEdge('D', 'E', 1);

        System.out.println("Adjacency matrix representation of the graph:");
        System.out.println(graph);

        System.out.println("Breadth-first traversal of the graph:");
        graph.bfs('A');

        System.out.println("\n\nshow");
        graph.show();
    }
}
