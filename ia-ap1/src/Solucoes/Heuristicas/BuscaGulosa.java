package Solucoes.Heuristicas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import Problema.*;

public class BuscaGulosa {

    // Dados heuristicos
    Map<Node, Integer> dados_heuristicos = new HashMap<Node, Integer>();

    // Representa a distancia reta para a cidade de Bucharest
    private Graph graph;
    private Node start;
    private Node goal;

    public void CompletarDadosHeuristicos() {
        /*
         * this.distancia_heuristica = [
         * "Arad": 366,
         * "Bucharest": 0,
         * "Craiova": 160,
         * "Drobeta": 242,
         * "Eforie": 161,
         * "Fagaras": 176,
         * "Giurgiu": 77,
         * "Hirsova": 151,
         * "Iasi": 226,
         * "Lugoj": 244,
         * "Mehadia": 241,
         * "Neamt": 234,
         * "Oradea": 380,
         * "Pitesti": 100,
         * "Rimnicu Vilcea": 193,
         * "Sibiu": 253,
         * "Timisoara": 329,
         * "Urziceni": 80,
         * "Vaslui": 199,
         * "Zerind": 374,
         * ]
         */
        this.dados_heuristicos.put(this.graph.getState("Arad"), 366);
        this.dados_heuristicos.put(this.graph.getState("Bucharest"), 0);
        this.dados_heuristicos.put(this.graph.getState("Craiova"), 160);
        this.dados_heuristicos.put(this.graph.getState("Drobeta"), 242);
        this.dados_heuristicos.put(this.graph.getState("Eforie"), 161);
        this.dados_heuristicos.put(this.graph.getState("Fagaras"), 176);
        this.dados_heuristicos.put(this.graph.getState("Giurgiu"), 77);
        this.dados_heuristicos.put(this.graph.getState("Hirsova"), 151);
        this.dados_heuristicos.put(this.graph.getState("Iasi"), 226);
        this.dados_heuristicos.put(this.graph.getState("Lugoj"), 244);
        this.dados_heuristicos.put(this.graph.getState("Mehadia"), 241);
        this.dados_heuristicos.put(this.graph.getState("Neamt"), 234);
        this.dados_heuristicos.put(this.graph.getState("Oradea"), 380);
        this.dados_heuristicos.put(this.graph.getState("Pitesti"), 100);
        this.dados_heuristicos.put(this.graph.getState("Rimnicu Vilcea"), 193);
        this.dados_heuristicos.put(this.graph.getState("Sibiu"), 253);
        this.dados_heuristicos.put(this.graph.getState("Timisoara"), 329);
        this.dados_heuristicos.put(this.graph.getState("Urziceni"), 80);
        this.dados_heuristicos.put(this.graph.getState("Vaslui"), 199);
        this.dados_heuristicos.put(this.graph.getState("Zerind"), 374);

    }

    public BuscaGulosa(Graph graph, Node start, Node goal) {
        this.graph = graph;
        this.start = start;
        this.goal = goal;
        this.CompletarDadosHeuristicos();
    }

    public void search() {

        // nesse algoritmo, a comparação é feita apenas com os dados heuristicos
        Comparator<? super Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return dados_heuristicos.get(o1) - dados_heuristicos.get(o2);
            }
        };

        PriorityQueue<Node> borda = new PriorityQueue<Node>(comparator);
        borda.add(start);

        ArrayList<Node> explorados = new ArrayList<Node>();

        while (!borda.isEmpty()) {
            Node node = borda.remove();
            explorados.add(node);

            if (node.equals(goal)) {
                System.out.println("Objetivo encontrado!");
                System.out.println("Caminho: " + node.getPath());
                System.out.println("Custo: " + node.getCost());
                return;
            }

            for (Transition t : node.getTransitions()) {
                Node to = t.getTo();

                if (!explorados.contains(to) && !borda.contains(to)) {
                    to.setParent(node);
                    to.setCost(node.getCost() + t.getCost());
                    borda.add(to);
                } else if (borda.contains(to)) {
                    if (to.getCost() > node.getCost() + t.getCost()) {
                        to.setParent(node);
                        to.setCost(node.getCost() + t.getCost());
                    }
                }

            }
        }
    }

}
