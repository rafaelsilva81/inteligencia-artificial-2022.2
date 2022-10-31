package com.ia.ap1;

import com.ia.ap1.issues.WorldMap;
import com.ia.ap1.solutions.blind.BuscaCustoUniforme;

public class AppBuscaCustoUniforme {
    public static void main(String[] args) {
        WorldMap romania = Util.getWorldMapForRomania();

        System.out.println("Total de estados (Romania): " + romania.getStates().size());

        String source = Util.getSourceByArguments(args, "Arad", romania);

        System.out.println("Busca Custo Uniforme");
        BuscaCustoUniforme buscaCustoUniforme = new BuscaCustoUniforme(romania, source, "Bucharest");
        buscaCustoUniforme.search();

    }
}
