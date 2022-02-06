package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Map<Boolean, Player> players = Map.of(false, new Player(), true, new Player());
        Map<Boolean, Board> boards = Map.of(false, new Board(), true, new Board());
        //Map<Boolean, Ship> ships = Map.of(false, new Ship(), true, new Ship());

        game.startGame(players, boards);
        boolean currentPlayer = false;

        System.out.println("The game starts!");
        while (!players.get(currentPlayer).hasWon()) {
            boards.get(!currentPlayer).printOpponentBoard();
            System.out.println("---------------------");
            boards.get(currentPlayer).printMyBoard();
            game.makeMove(players.get(currentPlayer), boards.get(!currentPlayer));
            if (currentPlayer == false) {
                System.out.println("Player 1, it's your turn:");
            } else {
                System.out.println("Player 2, it's your turn: ");
            }
            currentPlayer = !currentPlayer;


        }
    }
}
