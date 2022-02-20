package racingcar.model;

import java.util.Objects;

public class Car {

    private final Name name;
    private final Location location;
    private final Moving moving;

    public Car(String name) {
        this(new Name(name), new Location(), new BiggerNumberMoving());
    }

    public Car(Name name, Location location, Moving moving) {
        this.name = name;
        this.location = location;
        this.moving = moving;
    }

    public void tryMove(int number) {
        if (moving.canMove(number)) {
            this.location.increase();
        }
    }

    public int getCarPosition() {
        return location.getLocation();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isSamePosition(int position) {
        return Objects.equals(position, getCarPosition());
    }

    public int compareWinnerPosition(Car comparableCar) {
        int comparableCarLocation = comparableCar.location.getLocation();
        return this.location.getLocation() - comparableCarLocation;
    }
}
