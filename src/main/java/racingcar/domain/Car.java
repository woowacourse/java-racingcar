package racingcar.domain;

public class Car {

    private static final int MINIMUM_MOVE_POWER = 4;

    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(final int power) {
        if (isEnough(power)) {
            position.increase();
        }
    }

    private boolean isEnough(final int power) {
        return power >= MINIMUM_MOVE_POWER;
    }

    public boolean isSamePosition(final Car car) {
        return this.position.equals(car.position);
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
