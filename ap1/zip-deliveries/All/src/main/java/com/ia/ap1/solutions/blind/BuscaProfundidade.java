package com.ia.ap1.solutions.blind;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import com.ia.ap1.issues.Node;
import com.ia.ap1.issues.Transition;
import com.ia.ap1.issues.WorldMap;

public class BuscaProfundidade {

    // Busca em Profundidade
    private WorldMap graph;
    private String start;
    private String goal;

    public BuscaProfundidade(WorldMap graph, String start, String goal) {
        this.graph = graph;
        this.start = start;
        this.goal = goal;
    }

    public void search() {

        Stack<Node> borda = new Stack<Node>();
        ArrayList<Node> visitados = new ArrayList<Node>();

        List<String> startChildrens = graph.getStateTransitions(start).stream()
                .map(transition -> (transition.getTo())).collect(Collectors.toList());

        borda.add(Node.createNode(start, startChildrens, 0));

        while (!borda.isEmpty()) {
            Node node = borda.pop();
            visitados.add(node);

            if (node.name.equals(goal)) {
                System.out.println("Caminho encontrado!");
                System.out.println("Custo: " + node.getCost());
                System.out.println("Caminho: " + node.getPath());
                return;
            }

            for (String child : node.getChildrens()) {

                boolean inBorda = borda.stream().anyMatch(n -> {
                    return n.name == child;
                });

                boolean inVisitados = visitados.stream().anyMatch(n -> {
                    return n.name == child;
                });

                List<String> childrens = graph.getStateTransitions(child).stream()
                        .map(transition -> (transition.getTo())).collect(Collectors.toList());
                Transition transition = graph.getUniqueTransition(node.name, child);

                // custo total da transição
                int cost = node.getCost() + transition.getCost();

                if (!inBorda && !inVisitados) {

                    borda.add(Node.createNodeWithParent(child, childrens, cost, node));
                }

            }
        }

    }

}
