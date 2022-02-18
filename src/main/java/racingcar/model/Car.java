package racingcar.model;

import java.util.Objects;

public class Car {

    private final static int MOVABLE_NUMBER = 4;

    private final Name name;
    private final Location location;
    private final Moving moving;

    public Car(String carName) {
        this.name = new Name(carName);
        this.location = new Location();
        this.moving = new BiggerNumberMoving(MOVABLE_NUMBER);
    }

    public void tryMove(Integer number) {
        if (moving.canMove(number)) {
            this.location.increase();
        }
    }

    public Integer getCarPosition() {
        return location.getLocation();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isWinnerPosition(Integer position) {
        return Objects.equals(position, getCarPosition());
    }
}
