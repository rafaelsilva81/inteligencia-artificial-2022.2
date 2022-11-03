package com.ia.ap1;

import com.ia.ap1.problem.WorldMap;
import com.ia.ap1.solutions.blind.BuscaCustoUniforme;
import com.ia.ap1.solutions.blind.BuscaLargura;
import com.ia.ap1.solutions.blind.BuscaProfundidade;
import com.ia.ap1.solutions.heuristics.BuscaAEstrela;
import com.ia.ap1.solutions.heuristics.BuscaGulosa;

public class App {

        public static void main(String[] args) {

                // Constroi o mapa
                WorldMap romania = Util.getWorldMapForRomania();

                // Obtem dados do terminal
                /*
                 * OBS: Se nenhum parametro for recebid pelo terminal, o programa irá executar
                 * a busca em profundidade com o estado inicial Arad e o estado final Bucharest
                 */

                String source = Util.getSourceByArguments(args, "Arad", romania);

                /*
                 * Realiza todas as buscas
                 */
                System.out.println("Busca em Largura");
                BuscaLargura bl = new BuscaLargura(romania, source, "Bucharest");
                bl.search();

                System.out.println("Busca de Custo Uniforme");
                BuscaCustoUniforme bcu = new BuscaCustoUniforme(romania, source, "Bucharest");
                bcu.search();

                System.out.println("Busca em Profundidade");
                BuscaProfundidade bf = new BuscaProfundidade(romania, source, "Bucharest");
                bf.search();

                System.out.println("Busca Gulosa (Heurística)");
                BuscaGulosa bg = new BuscaGulosa(romania, source, "Bucharest");
                bg.search();

                System.out.println("Busca A* (Heurística)");
                BuscaAEstrela ba = new BuscaAEstrela(romania, source, "Bucharest");
                ba.search();

        }
}
