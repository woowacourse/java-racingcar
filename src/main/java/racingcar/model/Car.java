package racingcar.model;

public class Car {

    private Name name;
    private Location location;

    public Car(String carName) {
        this.name = new Name(carName);
        this.location = new Location();
    }

    public void move() {
        this.location.increase();
    }

    public Integer getLocation() {
        return location.getCurrentPosition();
    }

    public Name getName() {
        return this.name;
    }
}
