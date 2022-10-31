package com.ia.ap1.solutions.blind;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ia.ap1.issues.Node;
import com.ia.ap1.issues.Transition;
import com.ia.ap1.issues.WorldMap;

public class BuscaLargura {

    // Busca em Largura
    private WorldMap graph;
    private String start;
    private String goal;

    public BuscaLargura(WorldMap graph, String start, String goal) {
        this.graph = graph;
        this.start = start;
        this.goal = goal;
    }

    public Node search() {
        List<Node> borda = new ArrayList<Node>();
        List<Node> visitados = new ArrayList<Node>();

        List<String> startChildrens = graph.getStateTransitions(start).stream()
                .map(transition -> (transition.getTo())).collect(Collectors.toList());

        borda.add(Node.createNode(start, startChildrens, 0));

        while (!borda.isEmpty()) {
            Node node = borda.remove(0);
            visitados.add(node);

            if (node.getName().equals(goal)) {
                System.out.println("Objetivo encontrado!");
                System.out.println("Caminho: " + node.getPath());
                System.out.println("Custo: " + node.getCost());
                return node;
            }

            for (String child : node.getChildrens()) {

                if (!borda.stream().anyMatch(n -> {
                    return n.name == child;
                }) && !visitados.stream().anyMatch(n -> {
                    return n.name == child;
                })) {

                    List<String> childrens = graph.getStateTransitions(child).stream()
                            .map(transition -> (transition.getTo())).collect(Collectors.toList());

                    Transition transition = graph.getUniqueTransition(node.name, child);
                    borda.add(Node.createNodeWithParent(child, childrens, node.getCost() + transition.getCost(), node));
                }
            }
        }

        return null;
    }

}
