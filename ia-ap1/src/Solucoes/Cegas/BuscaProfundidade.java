package Solucoes.Cegas;

import java.util.ArrayList;
import java.util.Stack;

import Problema.Graph;
import Problema.Node;
import Problema.Transition;

public class BuscaProfundidade {
    
    //Busca em Profundidade
    private Graph graph;
    private Node start;
    private Node goal;

    public BuscaProfundidade(Graph graph, Node start, Node goal) {
        this.graph = graph;
        this.start = start;
        this.goal = goal;
    }

    public void search() {

        Stack<Node> borda = new Stack<Node>();
        ArrayList<Node> visitados = new ArrayList<Node>();

        borda.add(start);

        while (!borda.isEmpty()) {
            Node node = borda.pop();
            visitados.add(node);

            for (Transition transition : node.getTransitions()) {
                Node to = transition.getTo();
                if (!visitados.contains(to) && !borda.contains(to)) {
                    if (to.equals(goal)) {
                        System.out.println("Objetivo encontrado!");
                        System.out.println("Caminho: " + to.getPath());
                        System.out.println("Custo: " + to.getCost());
                        return;
                    }

                    //Adicionar filho a borda
                    to.setParent(node);
                    to.setCost(node.getCost() + transition.getCost());
                    borda.add(to);
                }
            }
        }
        
    }
        

}
