package com.bridgelabz.SnakeAndLadders;

public class SnakesAndLadders {
    static final int START_POSITION = 0;
    static final int NO_PLAY = 0;
    static final int IF_LADDER = 1;
    static final int IF_SNAKE = 2;
    static final int MAX_POSITION = 100;
    static int player1Position = 0;
    static int player2Position = 0;
    static int die = 0;

    public enum CurrentPlayer {
        PLAYER, COMPUTER
    }

    static CurrentPlayer toss() {
        if ((int) (Math.random() * 10) % 2 == 1) {
            return CurrentPlayer.PLAYER;
        } else {
            return CurrentPlayer.COMPUTER;
        }
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Snakes And Ladders");
        CurrentPlayer currentPlayer = toss();
        while (player1Position < 100 && player2Position < 100) {
            int dieNum = (int) (Math.random() * 10) % 6 + 1;
            int option = (int) (Math.random() * 10) % 3;
            switch (option) {
                case IF_LADDER:
                    if (currentPlayer == CurrentPlayer.PLAYER) {
                        player1Position += dieNum;
                        if (player1Position > MAX_POSITION) {
                            player1Position -= dieNum;
                        }
                    } else {
                        player2Position += dieNum;
                        if (player2Position > MAX_POSITION) {
                            player2Position -= dieNum;
                        }
                    }
                    break;
                case IF_SNAKE:
                    if (currentPlayer == CurrentPlayer.PLAYER) {
                        player1Position -= dieNum;
                        if (player1Position < START_POSITION) {
                            player1Position = 0;
                        }
                    } else {
                        player2Position -= dieNum;
                        if (player2Position < START_POSITION) {
                            player2Position = 0;
                        }
                    }
                    currentPlayer = (currentPlayer == CurrentPlayer.PLAYER) ? CurrentPlayer.COMPUTER : CurrentPlayer.PLAYER;
                    break;
                default:

            }
            System.out.println("Current position of player is:" + player1Position);
            System.out.println("Current position of player is:" + player2Position);
            die++;
        }
        System.out.println("Total number of times Die rolled are :" + die);
        System.out.println(currentPlayer + "wins the game");
    }
}

