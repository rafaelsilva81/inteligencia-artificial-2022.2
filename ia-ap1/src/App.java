import Problema.Graph;
import Problema.Node;

import Solucoes.Cegas.*;
import Solucoes.Heuristicas.*;

public class App {
    
    public static Graph buildGraph() {
        Graph graph = new Graph();
        
        Node arad = new Node("Arad");
        Node zerind = new Node("Zerind");
        Node oradea = new Node("Oradea");
        Node sibiu = new Node("Sibiu");
        Node timisoara = new Node("Timisoara");
        Node lugoj = new Node("Lugoj");
        Node mehadia = new Node("Mehadia");
        Node dobreta = new Node("Dobreta");
        Node craiova = new Node("Craiova");
        Node rimnicu_vilcea = new Node("Rimnicu Vilcea");
        Node fagaras = new Node("Fagaras");
        Node pitesti = new Node("Pitesti");
        Node bucharest = new Node("Bucharest");
        Node giurgiu = new Node("Giurgiu");
        Node urziceni = new Node("Urziceni");
        Node hirsova = new Node("Hirsova");
        Node eforie = new Node("Eforie");
        Node vaslui = new Node("Vaslui");
        Node iasi = new Node("Iasi");
        Node neamt = new Node("Neamt");

        graph.addState(arad);
        graph.addState(zerind);
        graph.addState(oradea);
        graph.addState(sibiu);
        graph.addState(timisoara);
        graph.addState(lugoj);
        graph.addState(mehadia);
        graph.addState(dobreta);
        graph.addState(craiova);
        graph.addState(rimnicu_vilcea);
        graph.addState(fagaras);
        graph.addState(pitesti);
        graph.addState(bucharest);
        graph.addState(giurgiu);
        graph.addState(urziceni);
        graph.addState(hirsova);
        graph.addState(eforie);
        graph.addState(vaslui);
        graph.addState(iasi);
        graph.addState(neamt);

        graph.addTransition("Arad", "Zerind", 75);
        graph.addTransition("Arad", "Timisoara", 118);
        graph.addTransition("Arad", "Sibiu", 140);
        graph.addTransition("Zerind", "Oradea", 71);
        graph.addTransition("Oradea", "Sibiu", 151);
        graph.addTransition("Sibiu", "Fagaras", 99);
        graph.addTransition("Sibiu", "Rimnicu Vilcea", 80);
        graph.addTransition("Timisoara", "Lugoj", 111);
        graph.addTransition("Lugoj", "Mehadia", 70);
        graph.addTransition("Mehadia", "Dobreta", 75);
        graph.addTransition("Dobreta", "Craiova", 120);
        graph.addTransition("Craiova", "Rimnicu Vilcea", 146);
        graph.addTransition("Craiova", "Pitesti", 138);
        graph.addTransition("Rimnicu Vilcea", "Pitesti", 97);
        graph.addTransition("Fagaras", "Bucharest", 211);
        graph.addTransition("Pitesti", "Bucharest", 101);
        graph.addTransition("Bucharest", "Giurgiu", 90);
        graph.addTransition("Bucharest", "Urziceni", 85);
        graph.addTransition("Urziceni", "Hirsova", 98);
        graph.addTransition("Urziceni", "Vaslui", 142);
        graph.addTransition("Hirsova", "Eforie", 86);
        graph.addTransition("Vaslui", "Iasi", 92);
        graph.addTransition("Iasi", "Neamt", 87);

        return graph;
    }

    public static void main(String[] args) {
        Graph romania = buildGraph();

        //System.out.println(romania);
        
        //Receber argumentos da linha de comando
        //String[] args = {"Arad", "Bucharest"};
        
        System.out.println("\n");
        
        System.out.println("Busca em Largura");
        BuscaLargura buscaLargura = new BuscaLargura(romania, romania.getState("Arad"), romania.getState("Bucharest"));
        buscaLargura.search();

        System.out.println("\n");

        System.out.println("Busca de Custo Uniforme");
        BuscaCustoUniforme buscaCustoUniforme = new BuscaCustoUniforme(romania, romania.getState("Arad"), romania.getState("Bucharest"));
        buscaCustoUniforme.search();

        System.out.println("\n");

        System.out.println("Busca em Profundidade");
        BuscaProfundidade buscaProfundidade = new BuscaProfundidade(romania, romania.getState("Arad"), romania.getState("Bucharest"));
        buscaProfundidade.search();
    
        System.out.println("\n");
        
        System.out.println("Busca Gulosa (Heurística)");
        BuscaGulosa buscaGulosa = new BuscaGulosa(romania, romania.getState("Arad"), romania.getState("Bucharest"));
        buscaGulosa.search();

        System.out.println("\n");

        System.out.println("Busca A* (Heurística)");
        BuscaAEstrela buscaAestrela = new BuscaAEstrela(romania, romania.getState("Arad"), romania.getState("Bucharest"));
        buscaAestrela.search();

    }
}
