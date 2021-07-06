package com.lld.snake;

import java.util.UUID;

public class Player {
    private String name;
    private String color;
    private int currentPos;
    private String id;

    public Player(String name, int currentPos) {
        this.name = name;

        this.currentPos = currentPos;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
