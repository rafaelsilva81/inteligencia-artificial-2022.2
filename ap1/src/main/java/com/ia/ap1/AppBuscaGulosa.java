package com.ia.ap1;

import com.ia.ap1.issues.WorldMap;
import com.ia.ap1.solutions.heuristics.BuscaGulosa;

public class AppBuscaGulosa {
    public static void main(String[] args) {
        WorldMap romania = Util.getWorldMapForRomania();

        System.out.println("Total de estados (Romania): " + romania.getStates().size());

        String source = Util.getSourceByArguments(args, "Arad", romania);

        System.out.println("Busca Gulosa (Heurística)");
        BuscaGulosa buscaGulosa = new BuscaGulosa(romania, source, "Bucharest");
        buscaGulosa.search();

    }
}
