package racingcar.builder;

import racingcar.domain.Car;

public class CarBuilder {
    private String carName;

    public CarBuilder setCarName(String carName) {
        this.carName = carName;
        return this;
    }

    public Car build() {
        Car car = new Car(carName);
        return car;
    }
}
