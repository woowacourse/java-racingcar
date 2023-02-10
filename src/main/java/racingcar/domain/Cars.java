package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> carInformation;

    public Cars(List<Car> carInformation) {
        this.carInformation = carInformation;
    }

    public void addCarInformation(Car car) {
        this.carInformation.add(car);
    }

    public List<Car> getCarInformation() {
        return this.carInformation;
    }
}
