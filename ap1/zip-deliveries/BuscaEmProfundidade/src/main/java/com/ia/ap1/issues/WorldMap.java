package com.ia.ap1.issues;

import java.util.ArrayList;
import java.util.List;

public class WorldMap {

    private List<String> states;
    private List<Transition> transitions;

    public WorldMap() {
        this.states = new ArrayList<>();
        this.transitions = new ArrayList<>();
    }

    public List<String> getStates() {
        return states;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public List<Transition> getStateTransitions(String state) {
        List<Transition> selectedTransitions = new ArrayList<>();

        for (Transition t : transitions) {
            if (t.getFrom().equals(state)) {
                selectedTransitions.add(t);
            }
        }

        return selectedTransitions;
    }

    public Transition getUniqueTransition(String from, String to) {

        for (Transition t : transitions) {
            if (t.getFrom().equals(from) && t.getTo().equals(to)) {
                return t;
            }
        }

        return null;
    }

    public void addTransition(String from, String to, int cost) {

        if (from.equals(to))
            throw new Error("Não pode existir uma transição que leva ao mesmo estado!");

        if (!this.states.contains(from)) {
            this.states.add(from);
        }

        if (!this.states.contains(to)) {
            this.states.add(to);
        }

        if (getUniqueTransition(from, to) instanceof Transition)
            throw new Error("A transição informada já existe!");

        this.transitions.add(new Transition(from, to, cost));
    }

    public void addTwoWayTransition(String state1, String state2, int cost) {
        this.addTransition(state1, state2, cost);
        this.addTransition(state2, state1, cost);
    }

    public String toString() {
        String result = "";
        for (String state : states) {
            result += state + " -> " + getStateTransitions(state) + "\n";
        }
        return result;
    }

}
