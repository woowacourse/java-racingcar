package racingcar.domain;

import java.util.Random;

public class Car {
    private static final int RANGE = 10;
    private static final int THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= THRESHOLD) {
            position++;
        }
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANGE);
    }

    public String getCurrentPosition() {
        String currentPosition = name + " : ";
        for (int i = 0; i < position; i++) {
            currentPosition += "-";
        }
        return currentPosition;
    }

    public int comparePosition(int highScore) {
        if (position > highScore) {
            return position;
        }
        return highScore;
    }

    public boolean isChampion(int highScore) {
        return position == highScore;
    }

    public String getName() {
        return name;
    }
}
