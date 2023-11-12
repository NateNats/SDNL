package SDNL.UndirectedGraph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isLoop = true;

        Graph graph = getGraph();

        while(isLoop) {
            System.out.println();
            System.out.print("""
                    1. Graph
                    2. Depth First Search
                    3. Breadth First Search
                    Input:\s""");
            int pilih = input.nextInt();

           if(pilih == 1) {
               System.out.println(graph);
               graph.show();

           } else if (pilih == 2){
               System.out.println("Hasil Depth First Search:");
               graph.depthFirstSearch();
               System.out.println();

           } else if (pilih == 3){
               System.out.println("Hasil Breadth First Search: ");
               graph.breathFirstSearch();
            } else {
               isLoop = false;
           }
        }
    }

    private static Graph getGraph() {
        Graph graph = new Graph();
        //laporan lama
//        char[] arr = {'A', 'B', 'C', 'D', 'G', 'F', 'H'};
//        for (char vertex: arr) {
//            graph.addVertex(vertex);
//        }
//
//        graph.addEdge('A', 'B', 5);
//        graph.addEdge('A', 'D', 7);
//        graph.addEdge('A', 'G', 4);
//        graph.addEdge('B', 'D', 6);
//        graph.addEdge('C', 'B', 7);
//        graph.addEdge('C', 'D', 6);
//        graph.addEdge('C', 'F', 9);
//        graph.addEdge('C', 'H', 15);
//        graph.addEdge('D', 'F', 5);
//        graph.addEdge('G', 'F', 9);
//        graph.addEdge('F', 'H', 8);

        //laporan baru
        char[] arr = {'A', 'B', 'C', 'D', 'G', 'F', 'H'};
        for (char vertex: arr) {
            graph.addVertex(vertex);
        }

        graph.addEdge('A', 'B', 5);
        graph.addEdge('A', 'D', 7);
        graph.addEdge('A', 'F', 4);
        graph.addEdge('B', 'C', 7);
        graph.addEdge('B', 'D', 6);
        graph.addEdge('D', 'C', 6);
        graph.addEdge('D', 'G', 5);
        graph.addEdge('F', 'G', 9);
        graph.addEdge('C', 'G', 9);
        graph.addEdge('C', 'H', 15);
        graph.addEdge('G', 'H', 8);

        return graph;
    }
}
