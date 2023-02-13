package racingcar.domain;

public class Winner {

    private final CarName carName;

    public Winner(String carName) {
        this.carName = new CarName(carName);
    }

    public String getName() {
        return carName.getCarName();
    }
}
