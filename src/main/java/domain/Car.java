package domain;

import java.util.Random;

public class Car {
    private int MIN_MOVE_NUMBER = 4;
    private int BOUND_NUMBER = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND_NUMBER)
    }

    public String judgeMove(int number) {
        if (number >= MIN_MOVE_NUMBER) {
            position ++;
            return "Go";
        }
        return "Stop";
    }
}
