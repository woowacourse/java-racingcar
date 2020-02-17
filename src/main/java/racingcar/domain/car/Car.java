package racingcar.domain.car;

import racingcar.domain.RandomNumber;

public class Car {
    private final Name name;
    private Location location;

    public Car(String name) {
        this.name = new Name(name);
        this.location = new Location();
    }

    public Car(String name, int location) {
        this.name = new Name(name);
        this.location = new Location(location);
    }

    public int getLocation() {
        return location.getLocation();
    }

    public void play() {
        RandomNumber randomNumber = new RandomNumber();
        int randomNo = randomNumber.getRandomNumber();
        if (randomNumber.canMove(randomNo)) {
            move();
        }
    }

    private void move() {
        location.moveForward();
    }

    public String getName() {
        return name.toString();
    }

    public String getLocationMarks() { return location.toString(); }

    public boolean isLocation(int maxLocation) {
        return this.location.equals(new Location(maxLocation));
    }
}
