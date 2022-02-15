package racingcar.model;

public class Car {

    private static final int MOVE_MIN_VALUE = 4;

    private final Name name;
    private final Location location;

    public Car(String carName) {
        this.name = new Name(carName);
        this.location = new Location();
    }

    public void tryMove(Integer number) {
        if (isMovable(number)) {
            this.location.increase();
        }
    }

    public Integer getCarPosition() {
        return location.getCurrentPosition();
    }

    public Name getName() {
        return this.name;
    }

    private boolean isMovable(Integer number) {
        return number >= MOVE_MIN_VALUE;
    }
}
