package domain;

import utils.RandomNumberGenerator;

public class Car {
    private static final int MOVE_LOWER_BOUND = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        int moveCount = RandomNumberGenerator.generateRandomNumber();
        if (moveCount >= MOVE_LOWER_BOUND) {
            this.distance++;
        }
    }

    public boolean isWinner(int distance) {
        return this.distance == distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }


}
