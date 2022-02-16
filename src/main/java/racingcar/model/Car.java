package racingcar.model;

import java.util.Objects;

public class Car implements RacingCar{

    private final Name name;
    private final Location location;
    private final int movableNumber;

    public Car(String carName) {
        this.name = new Name(carName);
        this.location = new Location();
        this.movableNumber = 4;
    }

    @Override
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
        return number >= movableNumber;
    }

    public boolean isWinnerPosition(Integer position) {
        return Objects.equals(position, getCarPosition());
    }
}
