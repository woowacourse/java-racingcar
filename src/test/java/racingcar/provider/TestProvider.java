package racingcar.provider;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class TestProvider {
    public static Cars createTestCars() {
        String carNames = "pobi,crong,honux";
        return Cars.of(carNames);
    }

    public static Car createTestCar(String carName) {
        return Car.of(carName);
    }

    public static Car createTestMoveCar(Car car) {
        car.move();
        return car;
    }
}
