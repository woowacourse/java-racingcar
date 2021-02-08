package racingcar.model;

public class Car {
    private static final int MOVE_POINT_NUMBER = 4;
    private static final int NAME_LEN = 5;

    private final String name;
    private int distance;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int distance) {
        validateName(name);
        this.name = name;
        this.distance = distance;
    }

    private void validateName(final String name) {
        if (name.length() > NAME_LEN) {
            throw new IllegalArgumentException("[Error] 자동차 이름은 5자 이하여야 합니다.\n");
        }
    }

    public int move(final int randomNumber) {
        if (checkMoveCondition(randomNumber)) {
            this.distance++;
        }
        return this.distance;
    }

    private boolean checkMoveCondition(final int randomNumber) {
        return (randomNumber >= MOVE_POINT_NUMBER);
    }

    public boolean isWinner(final int maxDistance) {
        return (maxDistance == this.distance);
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
