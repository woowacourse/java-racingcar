package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Digit;
import racingcar.domain.Car;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {
    private CarService carService;

    @BeforeEach
    public void setUp() {
        carService = new CarService();
    }

    @DisplayName("조건을 만족하는 자동차는 전진 성공")
    @Test
    void decideMovableCar_자동차가_전진할지_멈출지_판단() {
        int numberOfCars = 4;
        int numberOfMovableCar = 2;
        int movedPosition = 1;

        List<Integer> randoms = Arrays.stream(new int[numberOfCars])
                .boxed()
                .collect(Collectors.toList());
        List<Car> cars = new ArrayList();

        for (int i = 0; i < numberOfMovableCar; i++) {
            randoms.set(i, Digit.MOVEMENT_CRITERION.getDigit());
        }
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car("pobi" + i));
        }

        carService.decideMovableCar(cars, randoms);

        int movedCount = (int) cars.stream()
                .filter(car -> car.getPosition() == movedPosition)
                .count();

        assertThat(movedCount).isEqualTo(numberOfMovableCar);
    }

    @DisplayName("자동차가 조건을 만족하면 전진 성공")
    @Test
    void moveIfPossible_자동차가_조건을_만족하면_전진() {
        int random = RandomUtils.nextInt(Digit.MINIMUM_RANDOM_VALUE.getDigit(),
                Digit.MAXIMUM_RANDOM_VALUE.getDigit());
        int expectedPosition = 0;
        Car car = new Car("pobi");

        if (random >= Digit.MOVEMENT_CRITERION.getDigit()) {
            expectedPosition++;
        }
        carService.moveIfPossible(car, random);
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}