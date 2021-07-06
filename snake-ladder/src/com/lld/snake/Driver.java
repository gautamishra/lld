package com.lld.snake;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int noOfSnakes = scanner.nextInt();
        List<Sanke> snakes = new ArrayList<>();
        for (int i = 0; i < noOfSnakes; i++) {
            snakes.add(new Sanke(scanner.nextInt(), scanner.nextInt()));
        }

        int noOfLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<Ladder>();
        for (int i = 0; i < noOfLadders; i++) {
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }

        int noOfPlayers = scanner.nextInt();
        Queue<Player> players = new LinkedList<>();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(scanner.next() , 0));
        }


        GameService gameService = new GameService();
        gameService.setPlayers(players);
        gameService.getBoard().setLadders(ladders);
        gameService.getBoard().setSnakes(snakes);
        gameService.startGame();
    }
}
