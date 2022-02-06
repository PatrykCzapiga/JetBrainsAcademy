package com.company;


public class Board {
    private String firstRow = "  1 2 3 4 5 6 7 8 9 10";
    private char[] firstColumn = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private char[][] myBoard = {{'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'}};

    private char[][] opponentBoard = {{'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'}};
    private final static char hitSymbol = 'X';
    private final static char missSymbol = 'M';
    private final static char shipSymbol = 'O';

    private Ship ship = new Ship();

    void placeHit(int[] coords) {
        myBoard[coords[0]][coords[1]] = this.hitSymbol;
        opponentBoard[coords[0]][coords[1]] = this.hitSymbol;
    }

    void placeMiss(int[] coords) {
        myBoard[coords[0]][coords[1]] = this.missSymbol;
        opponentBoard[coords[0]][coords[1]] = this.missSymbol;
    }

    void placeShip(int[] coords, int id) {
        if (coords[1] == coords[3]) {
            if (coords[0] > coords[2]) {
                for (int j = coords[2]; j <= coords[0]; j++) {
                    myBoard[j][coords[1]] = (char) (id + 48);
                }
            } else {
                for (int j = coords[0]; j <= coords[2]; j++) {
                    myBoard[j][coords[1]] = (char) (id + 48);
                }
            }
        } else if (coords[0] == coords[2]) {
            if (coords[1] > coords[3]) {
                for (int j = coords[3]; j <= coords[1]; j++) {
                    myBoard[coords[0]][j] = (char) (id + 48);
                }
            } else {
                for (int j = coords[1]; j <= coords[3]; j++) {
                    myBoard[coords[0]][j] = (char) (id + 48);
                }
            }
        }
    }

    void printMyBoard() {
        System.out.println();
        System.out.println(firstRow);
        for (int i = 0; i < 10; i++) {
            System.out.print(firstColumn[i]);
            System.out.print(" ");
            for (int j = 0; j < 10; j++) {
                if (myBoard[i][j] == '0' || myBoard[i][j] == '1' || myBoard[i][j] == '2' || myBoard[i][j] == '3' || myBoard[i][j] == '4') {
                    System.out.print(shipSymbol);
                    System.out.print(" ");
                } else {
                    System.out.print(myBoard[i][j]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    void printOpponentBoard() {
        System.out.println();
        System.out.println(firstRow);
        for (int i = 0; i < 10; i++) {
            System.out.print(firstColumn[i]);
            System.out.print(" ");
            for (int j = 0; j < 10; j++) {

                System.out.print(opponentBoard[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    boolean validPlacement(int[] coords, String shipName, int shipSize) {

        if (coords[1] == coords[3] && coords[0] != coords[2]) {
            if (coords[0] - coords[2] == shipSize - 1 || coords[2] - coords[0] == shipSize - 1) {
                if (coords[0] > coords[2]) {
                    for (int i = coords[2]; i <= coords[0]; i++) {
                        if (i == coords[0] && i < 9 && myBoard[i + 1][coords[1]] != '~') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }
                        if (i == coords[2] && i > 0 && myBoard[i - 1][coords[1]] != '~') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }
                        if (myBoard[i][coords[1]] != '~') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }


                    }
                } else {
                    for (int i = coords[0]; i <= coords[2]; i++) {
                        if (i == coords[0] && i > 0 && myBoard[i - 1][coords[1]] != '~') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }
                        if (i == coords[2] && i < 9 && myBoard[i + 1][coords[1]] != '~') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }
                        if (myBoard[i][coords[1]] != '~') {

                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }
                    }
                }
            } else {
                System.out.println("Error! Error! Wrong length of the " + shipName + "! Try again:");
                System.out.println();
                return false;
            }
        } else if (coords[0] == coords[2] && coords[1] != coords[3]) {
            if (coords[1] - coords[3] == shipSize - 1 || coords[3] - coords[1] == shipSize - 1) {
                if (coords[1] > coords[3]) {
                    for (int i = coords[3]; i <= coords[1]; i++) {
                        if (i == coords[3] && i > 0 && myBoard[coords[0]][i - 1] != '~') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }
                        if (i == coords[1] && i < 9 && myBoard[coords[0]][i + 1] != '~') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }
                        if (myBoard[coords[0]][i] != '~') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }
                    }
                } else {
                    for (int i = coords[1]; i <= coords[3]; i++) {
                        if (i == coords[1] && i > 0 && myBoard[coords[0]][i - 1] != '~') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }
                        if (i == coords[3] && i < 9 && myBoard[coords[0]][i + 1] != '~') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }
                        if (myBoard[coords[0]][i] != '~') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            System.out.println();
                            return false;
                        }
                    }
                }
            } else {
                System.out.println("Error! Error! Wrong length of the " + shipName + "! Try again:");
                System.out.println();
                return false;
            }
        } else {
            System.out.println("Error! Wrong ship location! Try again:");
            System.out.println();
            return false;
        }
        return true;
    }

    boolean isWon() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (myBoard[i][j] == '0' || myBoard[i][j] == '1' || myBoard[i][j] == '2' || myBoard[i][j] == '3' || myBoard[i][j] == '4') {
                    return false;
                }
            }
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
        System.exit(0);
        return true;
    }

    boolean isDestroyed(char id) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (myBoard[i][j] == id) {
                    System.out.println("You hit a ship!");
                    return true;
                }
            }
        }
        if (isWon() == false) {
            System.out.println("You sank a ship! Specify a new target:");
            return false;
        }
        return false;
    }

    boolean hitOrMiss(int[] coords) {
        char temp;
        if (myBoard[coords[0]][coords[1]] == '0' || myBoard[coords[0]][coords[1]] == '1' || myBoard[coords[0]][coords[1]] == '2' || myBoard[coords[0]][coords[1]] == '3' || myBoard[coords[0]][coords[1]] == '4') {
            temp = myBoard[coords[0]][coords[1]];
            placeHit(coords);
            isDestroyed(temp);
            return true;
        } else if (myBoard[coords[0]][coords[1]] == '~') {
            placeMiss(coords);
            System.out.println("You missed.");

            return false;
        }
        printOpponentBoard();
        return false;
    }
}
