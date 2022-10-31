package com.ia.ap1;

import com.ia.ap1.issues.WorldMap;
import com.ia.ap1.solutions.blind.BuscaLargura;

public class AppBuscaLargura {
    public static void main(String[] args) {
        WorldMap romania = Util.getWorldMapForRomania();

        System.out.println("Total de estados (Romania): " + romania.getStates().size());

        String source = Util.getSourceByArguments(args, "Arad", romania);

        System.out.println("Busca em Largura");
        BuscaLargura buscaLargura = new BuscaLargura(romania, source, "Bucharest");
        buscaLargura.search();

    }
}
