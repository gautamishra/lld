package com.lld.snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Board {

    private int size = 100;

    private List<Sanke> snakes;
    private List<Ladder> ladders;

    Board (int size) {
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Sanke> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Sanke> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

}
