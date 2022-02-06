package com.company;


public class Ship {

    private static String[] shipName = {"Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer"};
    private static int[] shipSize = {5, 4, 3, 3, 2};

    public static String getName(int id) {
        return shipName[id];
    }

    public static int getSize(int id) {
        return shipSize[id];
    }
}
