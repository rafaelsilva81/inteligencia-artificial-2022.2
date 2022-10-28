package Solucoes.Cegas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import Problema.Graph;
import Problema.Node;
import Problema.Transition;

public class BuscaCustoUniforme {
    
    private Graph graph;
    private Node start;
    private Node goal;

    public BuscaCustoUniforme(Graph graph, Node start, Node goal) {
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
        ArrayList<Node> visitados = new ArrayList<Node>();

        borda.add(start);

        while (!borda.isEmpty()) {
            Node node = borda.remove();
            visitados.add(node);

            if (node.equals(goal)) {
                System.out.println("Objetivo encontrado!");
                System.out.println("Caminho: " + node.getPath());
                System.out.println("Custo: " + node.getCost());
                return;
            }

            for (Transition t : node.getTransitions()) {
                Node to = t.getTo();
                
                if (!visitados.contains(to) && !borda.contains(to)) {
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
