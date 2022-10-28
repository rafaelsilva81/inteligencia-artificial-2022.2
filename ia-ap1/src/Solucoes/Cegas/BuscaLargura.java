package Solucoes.Cegas;

import java.util.ArrayList;

import Problema.Graph;
import Problema.Node;
import Problema.Transition;

public class BuscaLargura {
    
    //Busca em Largura
    private Graph graph;
    private Node start;
    private Node goal;

    public BuscaLargura(Graph graph, Node start, Node goal) {
        this.graph = graph;
        this.start = start;
        this.goal = goal;
    }

    public void search() {
        // TODO: implementar busca em largura
        ArrayList<Node> borda = new ArrayList<Node>();
        ArrayList<Node> visitados = new ArrayList<Node>();

        borda.add(start);

        while (!borda.isEmpty()) {
            Node node = borda.remove(0);
            visitados.add(node);

            if (node.equals(goal)) {
                System.out.println("Objetivo encontrado!");
                System.out.println("Caminho: " + node.getPath());
                System.out.println("Custo: " + node.getCost());
                return;
            }

            for (Transition transition : node.getTransitions()) {
                Node to = transition.getTo();
                if (!visitados.contains(to) && !borda.contains(to)) {
                    to.setParent(node);
                    to.setCost(node.getCost() + transition.getCost());
                    borda.add(to);
                }
            }
        }



        
    }

}
