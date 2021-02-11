package racingcar.model;

public class Car {
    private static final int MOVE_POINT_NUMBER = 4;

    private final Name name;
    private int distance;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int distance) {
        this.name = new Name(name);
        this.distance = distance;
    }

    public void move(final int number) {
        if (checkMoveCondition(number)) {
            this.distance++;
        }
    }

    private boolean checkMoveCondition(final int number) {
        return (number >= MOVE_POINT_NUMBER);
    }

    public boolean isWinner(final int maxDistance) {
        return (maxDistance == this.distance);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return this.distance;
    }
}
