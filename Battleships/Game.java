package com.company;

import java.util.Scanner;
import java.util.Map;

public class Game {
    void startGame(Map<Boolean, Player> players, Map<Boolean, Board> boards) {
        Scanner scanner = new Scanner(System.in);

        boolean currentPlayer = false;
        System.out.println("Player 1, place your ships on the game field");
        boards.get(currentPlayer).printMyBoard();
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the coordinates of the " + Ship.getName(i) + " (" + Ship.getSize(i) + " cells)");
            int [] coords = players.get(currentPlayer).getCoordinatesOfShip();
            if (boards.get(currentPlayer).validPlacement(coords, Ship.getName(i), Ship.getSize(i))) {
                boards.get(currentPlayer).placeShip(coords, i);
                boards.get(currentPlayer).printMyBoard();
            } else {
                i--;
            }
        }
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();
        currentPlayer = !currentPlayer;
        System.out.println("Player 2, place your ships on the game field");
        boards.get(currentPlayer).printMyBoard();
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the coordinates of the " + Ship.getName(i) + " (" + Ship.getSize(i) + " cells)");
            int [] coords = players.get(currentPlayer).getCoordinatesOfShip();
            if (boards.get(currentPlayer).validPlacement(coords, Ship.getName(i), Ship.getSize(i))) {
                boards.get(currentPlayer).placeShip(coords, i);
                boards.get(currentPlayer).printMyBoard();
            } else {
                i--;
            }
        }
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();
    }

    void makeMove(Player player, Board board) {
        Scanner scanner = new Scanner(System.in);
        boolean validShot = false;
        //while(validShot != true) {
            if (board.hitOrMiss(player.getCoordinatesOfShot())) {
                validShot = true;
            }
        //}
        validShot = false;
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();
    }

}
