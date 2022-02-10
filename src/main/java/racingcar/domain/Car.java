package racingcar.domain;

public class Car {
    private final CarName carName;

    public Car(String carName) {
        this.carName = new CarName(carName);
    }
}
