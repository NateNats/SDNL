package SDNL.DirectedGraph;

public class Vertex {
    private final char label;
    private boolean flagVisited;

    public Vertex(char label) {
        this.label = label;
        this.flagVisited = false;
    }

    public char getLabel() {
        return label;
    }

    public boolean isFlagVisited() {
        return flagVisited;
    }

    public void setFlagVisited(boolean flagVisited) {
        this.flagVisited = flagVisited;
    }

    @Override
    public String toString() {
        return String.format("""
                Label: %s
                isVisited: %s
                
                """, label, flagVisited);
    }
}
