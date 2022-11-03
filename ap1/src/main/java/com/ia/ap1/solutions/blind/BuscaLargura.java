package com.ia.ap1.solutions.blind;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ia.ap1.problem.Node;
import com.ia.ap1.problem.Transition;
import com.ia.ap1.problem.WorldMap;

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
        // Não há um comparador, só pega o menor da lista sempre

        List<Node> borda = new ArrayList<Node>();
        List<Node> explorados = new ArrayList<Node>();

        // Obtem os filhos do estado inicial
        List<String> startChildrens = graph.getStateTransitions(start).stream()
                .map(transition -> (transition.getTo())).collect(Collectors.toList());

        borda.add(Node.createNode(start, startChildrens, 0));

        while (!borda.isEmpty()) {
            Node node = borda.remove(0);
            explorados.add(node);

            if (node.getName().equals(goal)) {
                System.out.println("Objetivo encontrado!");
                System.out.println("Caminho: " + node.getPath());
                System.out.println("Custo: " + node.getCost());
                return node;
            }

            for (String child : node.getChildrens()) {

                if (!borda.stream().anyMatch(n -> {
                    // Filtra a borda, buscando se o filho já está na borda
                    return n.name == child; // Checa pelo nome do nó (estado)
                }) && !explorados.stream().anyMatch(n -> {
                    // Filtra os explorados
                    return n.name == child;
                })) {
                    // Se o filho não tiver na borda nem nos explorados

                    // Otem lista de filhos
                    List<String> childrens = graph.getStateTransitions(child)
                            .stream() // Converte para stream
                            .map(transition -> (transition.getTo())) // Mapeia para o destino da transição
                            .collect(Collectors.toList()); // Converte para lista

                    // Obtem transicao
                    Transition transition = graph.getUniqueTransition(node.name, child);

                    // Insere na borda
                    borda.add(Node.createNodeWithParent(child, childrens, node.getCost() + transition.getCost(), node));
                }
            }
        }

        return null;
    }

}
