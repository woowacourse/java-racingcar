package racingcar.domain;

import java.util.Random;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_MAX = 10;
    private static final int RANDOM_MIN = 0;
    private static final String STATUS_SEPERATOR = " : ";
    private static final String DISTANCE_INDICATOR = "-";

    private final String name;
    private int distance;

    public Car(String name) {
        checkValidName(name);
        this.name = name;
        this.distance = 0;
    }

    private void checkValidName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void move() {
        if (canMove()) {
            this.distance++;
        }
    }

    private boolean canMove() {
        int randomNumber = new Random().nextInt(RANDOM_MAX - RANDOM_MIN) + RANDOM_MIN;

        if (randomNumber >= MOVE_THRESHOLD) {
            return true;
        }

        return false;
    }

    public String convertStatusToString() {
        StringBuilder SB = new StringBuilder();
        SB.append(this.name).append(STATUS_SEPERATOR);

        for (int i = 0; i < this.distance; i++) {
            SB.append(DISTANCE_INDICATOR);
        }

        return SB.toString();
    }
}
