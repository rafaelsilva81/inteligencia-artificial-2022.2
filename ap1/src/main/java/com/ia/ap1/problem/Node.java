package com.ia.ap1.problem;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public String name;
    public Node parent = null;
    public int cost_accumulated = 0;
    public List<String> childrens;

    public static Node createNode(String name, List<String> childrens, int initialCost) {

        Node node = new Node(name);

        node.setChildrens(childrens);
        node.setCost(initialCost);

        return node;
    }

    public static Node createNodeWithParent(String name, List<String> childrens, int initialCost, Node parent) {

        Node node = createNode(name, childrens, initialCost);

        node.setParent(parent);

        return node;
    }

    public Node(String name) {
        this.name = name;
        this.childrens = new ArrayList<>();
    }

    public void addChildren(String to) {
        childrens.add(to);
    }

    public void setChildrens(List<String> childrens) {
        this.childrens = childrens;
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

    public List<String> getChildrens() {
        return childrens;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getPath() {
        if (parent == null) {
            return name;
        } else {
            return parent.getPath() + " -[ " + (cost_accumulated - (parent != null ? parent.cost_accumulated : 0))
                    + " ]-> " + name;
        }
    }

}
