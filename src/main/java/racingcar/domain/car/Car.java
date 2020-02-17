package racingcar.domain.car;

import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumber;

public class Car {
    private final Name name;
    private Location location;

    public Car(String name) {
        this.name = new Name(name);
        this.location = new Location();
    }

    public int getLocation() {
        return location.getLocation();
    }

    public void play(NumberGenerator randomNumber) {
        if (RandomNumber.canMove(randomNumber.generateNumber())) {
            move();
        }
    }

    private void move() {
        location.moveForward();
    }

    public boolean isMaxLocation(int maxLocation) {
        return this.location.isMaxLocation(maxLocation);
    }

    public String getName() {
        return name.toString();
    }

    public String getLocationMarks() { return location.toString(); }
}
