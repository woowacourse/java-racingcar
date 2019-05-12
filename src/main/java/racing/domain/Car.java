package racing.domain;

import racing.view.ErrorMessages;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance;

    public Car(final String name) {
        this(name, 1);
    }

    public Car(final String name, final int distance) {
        this.name = getValidName(name);
        this.distance = distance;
    }

    private String getValidName(String name) {
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
            throw new IllegalArgumentException(ErrorMessages.ERR_CAR_BLANK_NAME.getMessage());
        }
    }

    private void checkNameLength(String trimmedName) {
        if (trimmedName.length() > Rules.MAX_CAR_NAME) {
            throw new IllegalArgumentException(ErrorMessages.ERR_CAR_NAME.getMessage());
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

    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public boolean isMatchDistance(Car car) {
        return this.distance == car.distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return this.distance - car.distance;
    }
}
