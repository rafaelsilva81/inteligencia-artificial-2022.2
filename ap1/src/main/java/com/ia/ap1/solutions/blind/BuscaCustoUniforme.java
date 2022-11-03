package com.ia.ap1.solutions.blind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import com.ia.ap1.problem.Node;
import com.ia.ap1.problem.Transition;
import com.ia.ap1.problem.WorldMap;

public class BuscaCustoUniforme {

    private WorldMap graph;
    private String start;
    private String goal;

    public BuscaCustoUniforme(WorldMap graph, String start, String goal) {
        this.graph = graph;
        this.start = start;
        this.goal = goal;
    }

    public void search() {

        // Fila de prioridade, comparar pelo custo acumulado
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.getCost() - n2.getCost();
            }
        };

        PriorityQueue<Node> borda = new PriorityQueue<Node>(comparator);
        List<Node> explorados = new ArrayList<>();

        List<String> startChildrens = graph.getStateTransitions(start).stream()
                .map(transition -> (transition.getTo())).collect(Collectors.toList());

        borda.add(Node.createNode(start, startChildrens, 0));

        while (!borda.isEmpty()) {
            Node node = borda.remove();
            explorados.add(node);

            if (node.name.equals(goal)) {
                System.out.println("Objetivo encontrado!");
                System.out.println("Caminho: " + node.getPath());
                System.out.println("Custo: " + node.getCost());
                return;
            }

            for (String child : node.getChildrens()) {

                List<String> childrens = graph.getStateTransitions(child).stream()
                        .map(transition -> (transition.getTo())).collect(Collectors.toList());
                Transition transition = graph.getUniqueTransition(node.name, child);

                boolean inBorda = borda.stream().anyMatch(n -> {
                    return n.name == child;
                });

                boolean inexplorados = explorados.stream().anyMatch(n -> {
                    return n.name == child;
                });

                // custo total da transição
                int cost = node.getCost() + transition.getCost();

                if (!inBorda && !inexplorados) {
                    borda.add(Node.createNodeWithParent(child, childrens, cost, node));
                } else if (inBorda) {
                    int oldCost = borda.stream().filter(n -> n.name == child).findAny().orElse(null).cost_accumulated;
                    if (oldCost > cost) {
                        // Altera para um novo caminho mais barato
                        borda.stream().filter(n -> n.name == child).forEach(n -> {
                            n.setCost(cost);
                            n.setParent(node);
                        });
                    }
                }

            }
        }

    }
}
