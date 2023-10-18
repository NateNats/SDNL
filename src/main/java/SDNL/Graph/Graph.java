package SDNL.Graph;

import java.util.Arrays;

public class Graph {
    int maxVertex = 5;
    Vertex[] vertexList;
    int[][] adjancencyMatrix;
    int countVertex = 0;

    public Graph() {
        adjancencyMatrix = new int[maxVertex][maxVertex];
        vertexList = new Vertex[maxVertex];

        for (int i = 0; i < maxVertex; i++) {
            for (int j = 0; j < maxVertex; j++) {
                adjancencyMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(char value) {

        if (countVertex != maxVertex) {
            Vertex vertex = new Vertex(value);

            vertexList[countVertex] = vertex;
            countVertex++;
        } else {
            System.out.println("Graph is full");
        }
    }

    public void addEdge(int row, int column, int value) {
        adjancencyMatrix[row][column] = value;
        adjancencyMatrix[column][row] = value;
    }

    public void addEdge(char row, char column, int value) {
        int rowInt = index(row);
        int columnInt = index(column);

        adjancencyMatrix[rowInt][columnInt] = value;
        adjancencyMatrix[columnInt][rowInt] = value;
    }

    private int index(char value) {
        for (int i = 0; i < vertexList.length; i++) {
            if (vertexList[i].getLabel() == value) {
                return i;
            }
        }

        return -1;
    }

    public void show(){
        System.out.print("|\t\t|\t");
        for (int i = 0; i < adjancencyMatrix.length; i++) {
            System.out.print(vertexList[i].getLabel());

            if (i < adjancencyMatrix.length-1) {
                System.out.print("\t|\t");
            }


        }
        System.out.print("\t|");
        System.out.print("\n");
        System.out.print("-".repeat(50));
        System.out.print("\n");
        for (int i = 0; i < adjancencyMatrix.length; i++) {
            System.out.print("|\t");
            System.out.print(vertexList[i].getLabel());
            System.out.print("\t|\t");

            for (int j = 0; j < adjancencyMatrix.length; j++) {
                System.out.print(adjancencyMatrix[i][j]);

                System.out.print("\t|\t");
            }

            System.out.print("\n");
        }
    }

    @Override
    public String toString() {
        StringBuilder sVertex = new StringBuilder();

        for (int i = 0; i < vertexList.length; i++) {
            sVertex.append(vertexList[i].getLabel());

            if (i < vertexList.length-1) {
                sVertex.append(", ");
            }
        }

        return String.format("""
                Max vertex: %d
                Vertex list: %s
                jumlah vertex: %d""", this.maxVertex, sVertex, this.countVertex);
    }
}
