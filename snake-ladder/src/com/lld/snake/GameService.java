package com.lld.snake;

import java.util.*;

public class GameService {

    private Board board;

    private int initialNumberOfPlayers;

    private Queue<Player> players; // Comment: Keeping players in game service as they are specific to this game and not the board. Keeping pieces in the board instead.
//    private boolean isGameCompleted;


    private int noOfDices; //Optional Rule 1
    private boolean shouldGameContinueTillLastPlayer; //Optional Rule 3
    private boolean shouldAllowMultipleDiceRollOnSix; //Optional Rule 4

    private static final int DEFAULT_BOARD_SIZE = 100; //The board will have 100 cells numbered from 1 to 100.
    private static final int DEFAULT_NO_OF_DICES = 1;

    GameService () {
        this(DEFAULT_BOARD_SIZE);
    }

    public GameService(int boardSize) {
        this.board = new Board(boardSize);  //Optional Rule 2
        this.players = new LinkedList<>();
        this.noOfDices = GameService.DEFAULT_NO_OF_DICES;
    }


    private void movePlayer(Player player, int positions) {
//        int oldPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
        int oldPosition = player.getCurrentPos();
        int newPosition = oldPosition + positions; // Based on the dice value, the player moves their piece forward that number of cells.

        int boardSize = board.getSize();

        // Can modify this logic to handle side case when there are multiple dices (Optional requirements)
        if (newPosition > boardSize) {
            newPosition = oldPosition; // After the dice roll, if a piece is supposed to move outside position 100, it does not move.
        } else {
            newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
        }

//        board.getPlayerPieces().put(player.getId(), newPosition);
        player.setCurrentPos(newPosition);

        System.out.println(player.getName() + " rolled a " + positions + " and moved from " + oldPosition +" to " + newPosition);
    }


    private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;
            for (Sanke snake : board.getSnakes()) {
                if (snake.getStart() == newPosition) {
                    newPosition = snake.getEnd(); // Whenever a piece ends up at a position with the head of the snake, the piece should go down to the position of the tail of that snake.
                }
            }

            for (Ladder ladder : board.getLadders()) {
                if (ladder.getStart() == newPosition) {
                    newPosition = ladder.getEnd(); // Whenever a piece ends up at a position with the start of the ladder, the piece should go up to the position of the end of that ladder.
                }
            }
        } while (newPosition != previousPosition); // There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.
        return newPosition;
    }


    private int getTotalValueAfterDiceRolls(Random rand) {
        // Can use noOfDices and setShouldAllowMultipleDiceRollOnSix here to get total value (Optional requirements)
            return Dice.getRand(rand);
    }

    private boolean hasPlayerWon(Player player) {
        // Can change the logic a bit to handle special cases when there are more than one dice (Optional requirements)
        int playerPosition = player.getCurrentPos();
        int winningPosition = board.getSize();
        return playerPosition == winningPosition; // A player wins if it exactly reaches the position 100 and the game ends there.
    }

    private boolean isGameCompleted() {
        // Can use shouldGameContinueTillLastPlayer to change the logic of determining if game is completed (Optional requirements)
        int currentNumberOfPlayers = players.size();
        return currentNumberOfPlayers < initialNumberOfPlayers;
    }


    public void startGame() {
        Random rand = new Random();
        while (!isGameCompleted()) {
            int totalDiceValue = getTotalValueAfterDiceRolls(rand); // Each player rolls the dice when their turn comes.
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer, totalDiceValue);
            if (hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " wins the game");
//                board.getPlayerPieces().remove(currentPlayer.getId());
            } else {
                players.add(currentPlayer);
            }
        }
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getInitialNumberOfPlayers() {
        return initialNumberOfPlayers;
    }

    public void setInitialNumberOfPlayers(int initialNumberOfPlayers) {
        this.initialNumberOfPlayers = initialNumberOfPlayers;
    }

//    public boolean isGameCompleted() {
//        return isGameCompleted;
//    }
//
//    public void setGameCompleted(boolean gameCompleted) {
//        isGameCompleted = gameCompleted;
//    }

    public int getNoOfDices() {
        return noOfDices;
    }

    public void setNoOfDices(int noOfDices) {
        this.noOfDices = noOfDices;
    }

    public boolean isShouldGameContinueTillLastPlayer() {
        return shouldGameContinueTillLastPlayer;
    }

    public void setShouldGameContinueTillLastPlayer(boolean shouldGameContinueTillLastPlayer) {
        this.shouldGameContinueTillLastPlayer = shouldGameContinueTillLastPlayer;
    }

    public boolean isShouldAllowMultipleDiceRollOnSix() {
        return shouldAllowMultipleDiceRollOnSix;
    }

    public void setShouldAllowMultipleDiceRollOnSix(boolean shouldAllowMultipleDiceRollOnSix) {
        this.shouldAllowMultipleDiceRollOnSix = shouldAllowMultipleDiceRollOnSix;
    }

    public static int getDefaultBoardSize() {
        return DEFAULT_BOARD_SIZE;
    }

    public static int getDefaultNoOfDices() {
        return DEFAULT_NO_OF_DICES;
    }



}
