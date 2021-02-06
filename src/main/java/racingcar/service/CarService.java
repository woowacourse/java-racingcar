package racingcar.service;

import racingcar.constant.Digit;
import racingcar.domain.Car;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    public void decideMovableCar(List<Car> cars, List<Integer> randoms) {
        if (randoms == null) {
            randoms = getRandoms(cars);
        }

        for (int i = 0; i < cars.size(); i++) {
            moveIfPossible(cars.get(i), randoms.get(i));
        }
    }

    private List<Integer> getRandoms(List<Car> cars) {
        List<Integer> randoms = new ArrayList();

        for (int i = 0; i < cars.size(); i++) {
            int random = RandomUtils.nextInt(Digit.MINIMUM_RANDOM_VALUE.getDigit(),
                    Digit.MAXIMUM_RANDOM_VALUE.getDigit());

            randoms.add(random);
        }

        return randoms;
    }

    public void moveIfPossible(Car car, int random) {
        if (random >= Digit.MOVEMENT_CRITERION.getDigit()) {
            car.move();
        }
    }
}
