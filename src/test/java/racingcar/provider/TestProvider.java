package racingcar.provider;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class TestProvider {
    public static Cars createTestCars() {
        String carNames = "pobi,crong,honux";
        return Cars.of(carNames);
    }

    public static Car createTestCar() {
        return Car.of("pobi");
    }

    public static Car createTestMoveCar() {
        Car car = Car.of("pobi");
        car.move();
        return car;
    }
}
