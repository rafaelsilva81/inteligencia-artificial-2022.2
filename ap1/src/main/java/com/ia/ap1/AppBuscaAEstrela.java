package com.ia.ap1;

import com.ia.ap1.issues.WorldMap;
import com.ia.ap1.solutions.heuristics.BuscaAEstrela;

public class AppBuscaAEstrela {
    public static void main(String[] args) {
        WorldMap romania = Util.getWorldMapForRomania();

        System.out.println("Total de estados (Romania): " + romania.getStates().size());

        String source = Util.getSourceByArguments(args, "Arad", romania);

        System.out.println("Busca A* (Heurística)");
        BuscaAEstrela buscaAEstrela = new BuscaAEstrela(romania, source, "Bucharest");
        buscaAEstrela.search();

    }
}
