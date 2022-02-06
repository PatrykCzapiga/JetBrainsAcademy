package com.company;

import java.util.Scanner;

public class Player {

    boolean hasWon() {
        return false;
    }

    int[] getCoordinatesOfShip() {
        Scanner scanner = new Scanner(System.in);
        int coords[] = {0, 0, 0, 0}; //startX, startY, endX, endY
        System.out.println();
        boolean isIncorrect = true;
        while (isIncorrect) {
            try {
            String[] enteredCoordinates = scanner.nextLine().split("\\s+");
            coords[0] = (int) enteredCoordinates[0].charAt(0) - 65;
            coords[1] = Integer.parseInt(enteredCoordinates[0].substring(1)) - 1;
            coords[2] = (int) enteredCoordinates[1].charAt(0) - 65;
            coords[3] = Integer.parseInt(enteredCoordinates[1].substring(1)) - 1;
            if (coords[0] >= 0 && coords[0] <= 9 && coords[1] >= 0 && coords[1] <= 9 && coords[2] >= 0 && coords[2] <= 9 && coords[3] >= 0 && coords[3] <= 9) {
                isIncorrect = false;
                return coords;
            } else {
                System.out.println("Error! You entered wrong coordinates! Try again:");
            }
        } catch (Exception e) {
                System.out.println("Error! You entered wrong coordinates! Try again:");
            }
        }
        return coords;
    }

    int[] getCoordinatesOfShot() {
        Scanner scanner = new Scanner(System.in);
        int coords[] = {0, 0}; //shotX, shotY
        System.out.println();
        boolean isIncorrect = true;
        while (isIncorrect) {
            try {
                String[] enteredCoordinates = scanner.nextLine().split("\\s+");
                System.out.println();
                coords[0] = (int) enteredCoordinates[0].charAt(0) - 65;
                coords[1] = Integer.parseInt(enteredCoordinates[0].substring(1)) - 1;
                if (coords[0] >= 0 && coords[0] <= 9 && coords[1] >= 0 && coords[1] <= 9) {
                    isIncorrect = false;
                    return coords;
                } else {
                    System.out.println("Error! You entered wrong coordinates! Try again:");
                }
            } catch (Exception e) {
                System.out.println("Error! You entered wrong coordinates! Try again:");
            }
        }
        return coords;
    }


}
