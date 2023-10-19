package SDNL.Graph;

import com.sun.security.jgss.GSSUtil;
import org.w3c.dom.ls.LSOutput;

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
        StringBuilder sb = new StringBuilder();

        sb.append('|');
        sb.append('\t');
        sb.append('\t');
        sb.append('|');

        for (Vertex v : vertexList) {

            sb.append('\t');
            sb.append(v.getLabel());
            sb.append('\t');
            sb.append('|');
        }

        int length = (sb.length());
        System.out.print("|");
        System.out.print("-".repeat((length * 2)-1));
        System.out.println("|");

        System.out.println(sb);
        System.out.print("|");
        printLine(length-3);
        System.out.println("|");

        for (int i = 0; i < vertexList.length; i++) {
            System.out.print("|\t" + vertexList[i].getLabel() + "\t|");
            for (int j = 0; j < vertexList.length; j++) {
                System.out.print("\t" + adjancencyMatrix[i][j] + "\t|");
            }
            System.out.print("\n|");
            printLine(length-3);
            System.out.println("|");
        }

    }

    public void printLine(int length) {
        int value = length/3;

        System.out.print("-".repeat(value));
        System.out.print("+");
        System.out.print("-".repeat(value));
        System.out.print("+");
        System.out.print("-".repeat(value));
        System.out.print("+");
        System.out.print("-".repeat(value));
        System.out.print("+");
        System.out.print("-".repeat(value));
        System.out.print("+");
        System.out.print("-".repeat(value));
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
