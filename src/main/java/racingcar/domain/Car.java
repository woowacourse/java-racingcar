package racingcar.domain;

import java.util.Random;

public class Car implements Comparable<Car> {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int RANGE_MAX = 9;
    private static final int DO_NOT_MOVE_THRESHOLD = 3;

    private final String name;
    private int position = 0;

    public Car(final String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move(int number) {
        if (number > DO_NOT_MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int generateRandomNumber() {
        return new Random().nextInt(RANGE_MAX + 1);
    }

    public boolean isTiebreaker(Car car) {
        return this.position == car.position;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}
