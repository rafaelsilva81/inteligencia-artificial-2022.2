package Problema;
import java.util.ArrayList;

public class Node {
    
    public String name;
    public Node parent = null;
    public int cost_accumulated = 0;
    public ArrayList<Transition> transitions = new ArrayList<Transition>();
    

    public Node(String name) {
        this.name = name;
    }
   
    public void addTransition(Node to, int cost) {
        transitions.add(new Transition(this, to, cost));
    }
    
    
    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setCost(int cost) {
        this.cost_accumulated = cost;
    }

    public String getName() {
        return name;
    }

    public Node getParent() {
        return parent;
    }

    public int getCost() {
        return cost_accumulated;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }
    
    @Override
    public String toString() {
        return name;
    }

    public String getPath() {
        if (parent == null) {
            return name;
        } else {
            return parent.getPath() + " -> " + name;
        }
    }
    

}