package racingcar.domain;

import java.util.Random;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_RANGE = 10;
    private static final int RANDOM_MIN = 0;

    private final String name;
    private int distance;

    public Car(String name) {
        checkValidName(name);
        this.name = name;
        this.distance = 0;
    }

    public static void checkValidName(String name) {
        if (name.length() > MAX_NAME_LENGTH
                || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 비어있지 않은 이름이어야 합니다.");
        }
    }

    /* 테스트용 메서드 */
    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            this.distance++;
        }
    }

    public void move() {
        if (generateRandNumber() >= MOVE_THRESHOLD) {
            this.distance++;
        }
    }

    public static int generateRandNumber() {
        return new Random().nextInt(RANDOM_RANGE) + RANDOM_MIN;
    }

    public boolean isWinner(int maxDistance) {
        return maxDistance == this.distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}
