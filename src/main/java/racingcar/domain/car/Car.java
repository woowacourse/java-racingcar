package racingcar.domain.car;

import racingcar.domain.Power;

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

    public void play(int goOrStopNumber) {
        if (Power.canMove(goOrStopNumber)) {
            move();
        }
    }

    private void move() {
        location.moveForward();
    }

    public boolean isMaxLocation(int maxLocation) {
        return this.location.isMatch(maxLocation);
    }

    public String getName() {
        return name.toString();
    }
}
