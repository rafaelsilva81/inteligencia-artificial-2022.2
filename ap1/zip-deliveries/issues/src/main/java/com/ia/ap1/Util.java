package com.ia.ap1;

import com.ia.ap1.issues.WorldMap;

public class Util {
    public static WorldMap getWorldMapForRomania() {
        WorldMap graph = new WorldMap();

        graph.addTwoWayTransition("Arad", "Zerind", 75);
        graph.addTwoWayTransition("Arad", "Timisoara", 118);
        graph.addTwoWayTransition("Arad", "Sibiu", 140);
        graph.addTwoWayTransition("Zerind", "Oradea", 71);
        graph.addTwoWayTransition("Oradea", "Sibiu", 151);
        graph.addTwoWayTransition("Sibiu", "Fagaras", 99);
        graph.addTwoWayTransition("Sibiu", "Rimnicu Vilcea", 80);
        graph.addTwoWayTransition("Timisoara", "Lugoj", 111);
        graph.addTwoWayTransition("Lugoj", "Mehadia", 70);
        graph.addTwoWayTransition("Mehadia", "Drobeta", 75);
        graph.addTwoWayTransition("Drobeta", "Craiova", 120);
        graph.addTwoWayTransition("Craiova", "Rimnicu Vilcea", 146);
        graph.addTwoWayTransition("Craiova", "Pitesti", 138);
        graph.addTwoWayTransition("Rimnicu Vilcea", "Pitesti", 97);
        graph.addTwoWayTransition("Fagaras", "Bucharest", 211);
        graph.addTwoWayTransition("Pitesti", "Bucharest", 101);
        graph.addTwoWayTransition("Bucharest", "Giurgiu", 90);
        graph.addTwoWayTransition("Bucharest", "Urziceni", 85);
        graph.addTwoWayTransition("Urziceni", "Hirsova", 98);
        graph.addTwoWayTransition("Urziceni", "Vaslui", 142);
        graph.addTwoWayTransition("Hirsova", "Eforie", 86);
        graph.addTwoWayTransition("Vaslui", "Iasi", 92);
        graph.addTwoWayTransition("Iasi", "Neamt", 87);

        return graph;
    }
}
