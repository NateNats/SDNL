package SDNL.coba;

import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph {
    int maxVertex = 10;
    Vertex[] vertexList;
    int[][] adjancencyMatrix;
    int countVertex = 0;

    public UndirectedGraph(int max) {
        adjancencyMatrix = new int[max][max];
        vertexList = new Vertex[max];

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                adjancencyMatrix[i][j] = 0;
            }
        }
    }

    int indexVertex(char label) {
        for (int i = 0; i < countVertex; i++) {
            if (vertexList[i].getLabel() == label) {
                return i;
            }
        }
        return -1;
    }

    void addVertex(char label) {
        Vertex vertex = new Vertex(label);

        if (countVertex < maxVertex) {
            vertexList[countVertex] = vertex;
            countVertex++;
        } else {
            System.out.println("Graph full");
        }
    }

    void addEdge(int start, int end, int weight) {
        adjancencyMatrix[start][end] = weight;
        adjancencyMatrix[end][start] = weight;
    }

    void addEdge(char start, char end, int weight) {
        int startIndex = indexVertex(start);
        int endIndex = indexVertex(end);

        if (startIndex != -1 && endIndex != -1) {
            addEdge(startIndex, endIndex, weight);

        } else {
            System.out.println("Edge vertices not found");

        }
    }

    void show() {
        for (int i = 0; i < countVertex; i++) {
            System.out.print(vertexList[i].getLabel() + " -> ");

            for (int j = 0; j < countVertex; j++) {
                System.out.print("(" + vertexList[j].getLabel() + ", " + adjancencyMatrix[i][j] + ") ");
            }
            System.out.println();
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < countVertex; i++) {
            s.append(vertexList[i].getLabel()).append(" -> ");
            for (int j = 0; j < countVertex; j++) {
                s.append("(").append(vertexList[j].getLabel()).append(", ").append(adjancencyMatrix[i][j]).append(") ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    void resetFlags() {
        for (int i = 0; i < countVertex; i++) {
            vertexList[i].setFlagVisited(false);
        }
    }

    void bfs(char start) {
        int startIndex = indexVertex(start);

        if (startIndex == -1) {
            System.out.println("Start vertex not found");
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        vertexList[startIndex].setFlagVisited(true);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            System.out.print(vertexList[index].getLabel() + " ");
        }
    }
}