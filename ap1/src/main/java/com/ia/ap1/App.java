package com.ia.ap1;

import com.ia.ap1.issues.WorldMap;
import com.ia.ap1.solutions.blind.BuscaCustoUniforme;
import com.ia.ap1.solutions.blind.BuscaLargura;
import com.ia.ap1.solutions.blind.BuscaProfundidade;
import com.ia.ap1.solutions.heuristics.BuscaAEstrela;
import com.ia.ap1.solutions.heuristics.BuscaGulosa;

public class App {

    public static void main(String[] args) {
        WorldMap romania = Util.getWorldMapForRomania();

        System.out.println("Total de estados (Romania): " + romania.getStates().size());

        String source = Util.getSourceByArguments(args, "Arad", romania);

        System.out.println("\n");

        System.out.println("Busca em Largura");
        BuscaLargura buscaLargura = new BuscaLargura(romania, source, "Bucharest");
        buscaLargura.search();

        System.out.println("\n");

        System.out.println("Busca de Custo Uniforme");
        BuscaCustoUniforme buscaCustoUniforme = new BuscaCustoUniforme(romania,
                source, "Bucharest");
        buscaCustoUniforme.search();

        System.out.println("\n");

        System.out.println("Busca em Profundidade");
        BuscaProfundidade buscaProfundidade = new BuscaProfundidade(romania,
                source,
                "Bucharest");
        buscaProfundidade.search();

        System.out.println("\n");

        System.out.println("Busca Gulosa (Heurística)");
        BuscaGulosa buscaGulosa = new BuscaGulosa(romania,
                source,
                "Bucharest");
        buscaGulosa.search();

        System.out.println("\n");

        System.out.println("Busca A* (Heurística)");
        BuscaAEstrela buscaAestrela = new BuscaAEstrela(romania,
                source,
                "Bucharest");
        buscaAestrela.search();

    }
}
