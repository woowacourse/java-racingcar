package racingcar.model;

public class Car {

    private final Name name;
    private final Location location;

    public Car(String carName) {
        this.name = new Name(carName);
        this.location = new Location();
    }

    public void move() {
        this.location.increase();
    }

    public Integer getCarPosition() {
        return location.getCurrentPosition();
    }

    public Name getName() {
        return this.name;
    }
}
