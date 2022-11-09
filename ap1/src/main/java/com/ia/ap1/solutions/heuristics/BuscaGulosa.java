package com.ia.ap1.solutions.heuristics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import com.ia.ap1.problem.Node;
import com.ia.ap1.problem.Transition;
import com.ia.ap1.problem.WorldMap;

public class BuscaGulosa {

    // Dados heuristicos
    Map<String, Integer> dados_heuristicos = new HashMap<>();

    // Representa a distancia reta para a cidade de Bucharest
    private WorldMap graph;
    private String start;
    private String goal;

    /* OBS: DADOS HEURISTICOS FUNCIONAM APENAS PARA BUCHAREST!! */
    public void CompletarDadosHeuristicos() {
        this.dados_heuristicos.put("Arad", 366);
        this.dados_heuristicos.put("Bucharest", 0);
        this.dados_heuristicos.put("Craiova", 160);
        this.dados_heuristicos.put("Drobeta", 242);
        this.dados_heuristicos.put("Eforie", 161);
        this.dados_heuristicos.put("Fagaras", 176);
        this.dados_heuristicos.put("Giurgiu", 77);
        this.dados_heuristicos.put("Hirsova", 151);
        this.dados_heuristicos.put("Iasi", 226);
        this.dados_heuristicos.put("Lugoj", 244);
        this.dados_heuristicos.put("Mehadia", 241);
        this.dados_heuristicos.put("Neamt", 234);
        this.dados_heuristicos.put("Oradea", 380);
        this.dados_heuristicos.put("Pitesti", 100);
        this.dados_heuristicos.put("Rimnicu Vilcea", 193);
        this.dados_heuristicos.put("Sibiu", 253);
        this.dados_heuristicos.put("Timisoara", 329);
        this.dados_heuristicos.put("Urziceni", 80);
        this.dados_heuristicos.put("Vaslui", 199);
        this.dados_heuristicos.put("Zerind", 374);

    }

    public BuscaGulosa(WorldMap graph, String start, String goal) {
        this.graph = graph;
        this.start = start;
        this.goal = goal;
        this.CompletarDadosHeuristicos();
    }

    public void search() {

        /*
         * nesse algoritmo,
         * a comparação é feita
         * apenas pela diferença dos
         * dados heuristicos
         */
        Comparator<? super Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return dados_heuristicos.get(o1.name) - dados_heuristicos.get(o2.name);
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
                    /*
                     * Aqui checa se o custo do nó que está na
                     * borda é maior que o custo do nó que está sendo analisado.
                     *
                     * Só adiciona o nó na borda se o custo for menor (melhor caminho)
                     */
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
