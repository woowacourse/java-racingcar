package racingcar.domain;

public class Car {
    private final CarName name;
    private final Position pos;

    public Car(String carName) {
        this.name = new CarName(carName);
        this.pos = new Position();
    }

}
