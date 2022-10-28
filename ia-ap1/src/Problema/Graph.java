package Problema;
import java.util.ArrayList;

public class Graph {
    
    public ArrayList<Node> states = new ArrayList<Node>();

    public void addState(Node state) {
        states.add(state);
    }

    public Node getState(String name) {
        for (Node state : states) {
            if (state.name.equals(name)) {
                return state;
            }
        }
        return null;
    }

    public void addTransition(String from, String to, int cost) {
        Node fromState = getState(from);
        Node toState = getState(to);
        fromState.addTransition(toState, cost);
    }

    public String toString() {
        String result = "";
        for (Node state : states) {
            result += state + " -> " + state.transitions + "\n";
        }
        return result;
    }

}
