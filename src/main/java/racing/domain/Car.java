package racing.domain;

import racing.view.ConsoleMessages;

public class Car implements Comparable<Car> {
    private static final int DEFAULT_DISTANCE = 1;

    private final String name;
    private int distance;

    public Car(final String name) {
        this(name, DEFAULT_DISTANCE);
    }

    public Car(final String name, final int distance) {
        this.name = validName(name);
        this.distance = distance;
    }

    private String validName(String name) {
        String trimmedName = trimName(name);

        checkBlankName(trimmedName);

        checkNameLength(trimmedName);

        return trimmedName;
    }

    private String trimName(String name) {
        return name.trim();
    }

    private void checkBlankName(String trimmedName) {
        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_CAR_BLANK_NAME.getMessage());
        }
    }

    private void checkNameLength(String trimmedName) {
        if (trimmedName.length() > Rules.MAX_CAR_NAME) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_CAR_NAME.getMessage());
        }
    }

    public int move(int number) {
        if (isMove(number)) {
            distance++;
        }
        return distance;
    }

    private boolean isMove(int number) {
        return number >= Rules.MIN_MOVABLE_NUMBER;
    }

    public boolean isMatchDistance(Car car) {
        return this.distance == car.distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Car car) {
        return this.distance - car.distance;
    }
}
