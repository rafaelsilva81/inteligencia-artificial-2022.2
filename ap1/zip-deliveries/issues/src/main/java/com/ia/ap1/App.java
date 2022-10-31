package com.ia.ap1;

import com.ia.ap1.issues.WorldMap;

public class App {

    public static void main(String[] args) {
        WorldMap romania = Util.getWorldMapForRomania();

        System.out.println("Total de estados (Romania): " + romania.getStates().size());

        System.out.println("\n");

        System.out.println(romania);

    }
}
