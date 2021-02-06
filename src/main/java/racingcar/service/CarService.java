package racingcar.service;

import racingcar.constant.Digit;
import racingcar.domain.Car;
import racingcar.utils.RandomUtils;

import java.util.List;

public class CarService {
    public void decideMovableCar(List<Car> cars) {
        for (Car car : cars) {
            int random = RandomUtils.nextInt(Digit.MINIMUM_RANDOM_VALUE.getDigit(),
                    Digit.MAXIMUM_RANDOM_VALUE.getDigit());

            moveIfPossible(car, random);
        }
    }

    public void moveIfPossible(Car car, int random) {
        if (random >= Digit.MOVEMENT_CRITERION.getDigit()) {
            car.move();
        }
    }
}
