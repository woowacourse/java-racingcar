package racingcar.domain;

public class Winner {

    private final CarName carName;

    public Winner(CarName carName) {
        this.carName = carName;
    }

    public CarName getName() {
        return carName;
    }
}
