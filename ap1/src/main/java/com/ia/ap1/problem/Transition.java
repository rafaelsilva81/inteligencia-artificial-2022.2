package com.ia.ap1.problem;

public class Transition {

    private String from;
    private String to;
    public int cost;

    public Transition(String from, String to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return from + " -[" + cost + "]-> " + to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }

}
