package racingcar.model;

public class Car {
    private static final int MOVE_POINT_NUMBER = 4;
    private static final int MOVE_FORWARD = 1;

    private final Name name;
    private Distance distance;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public void move(final int number) {
        if (checkMoveCondition(number)) {
            distance = new Distance(distance.getDistance() + MOVE_FORWARD);
        }
    }

    private boolean checkMoveCondition(final int number) {
        return (number >= MOVE_POINT_NUMBER);
    }

    public boolean isWinner(final Distance maxDistance) {
        return (maxDistance.equals(this.distance));
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return this.distance.getDistance();
    }
}
