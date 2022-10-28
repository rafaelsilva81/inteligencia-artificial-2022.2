package Problema;
public class Transition {
    
    public Node from;
    public Node to;
    public int cost;

    public Transition(Node from, Node to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return from + " -> " + to + " (" + cost + ")";
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }
    

}
