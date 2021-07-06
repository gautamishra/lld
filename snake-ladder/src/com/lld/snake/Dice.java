package com.lld.snake;

import java.util.Random;

public class Dice  {

    private static int bound = 6;

    Dice(int bound){
      this.bound = bound;
    }


    public static int getRand(Random random) {
        return random.nextInt(bound) + 1;
    }

    public int getBound() {
        return bound;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }
}
