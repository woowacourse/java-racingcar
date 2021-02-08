package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.constant.Digit;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {
    private CarService carService;

    @BeforeEach
    public void setUp() {
        carService = new CarService();
    }

    private static Stream<Arguments> initializeDecideMovableCar() {
        int numberOfCars = 4;
        int numberOfMovableCar = 2;

        List<Integer> randoms = Arrays.stream(new int[numberOfCars])
                .boxed()
                .collect(Collectors.toList());
        List<String> carNames = new ArrayList<>();

        for (int i = 0; i < numberOfMovableCar; i++) {
            randoms.set(i, Digit.MOVEMENT_CRITERION.getDigit());
        }
        for (int i = 0; i < numberOfCars; i++) {
            carNames.add("pobi" + i);
        }

        Cars cars = new Cars(carNames);

        return Stream.of(Arguments.of(cars, randoms));
    }

    @DisplayName("조건을 만족하는 자동차는 전진 성공")
    @ParameterizedTest
    @MethodSource("initializeDecideMovableCar")
    void decideMovableCar_자동차가_전진할지_멈출지_판단(Cars cars, List<Integer> randoms) {
        int movedPosition = 1;
        int numberOfMovableCar = (int) randoms.stream()
                .filter(random -> random.compareTo(Digit.MOVEMENT_CRITERION.getDigit()) >= 0)
                .count();

        carService.decideMovableCar(cars, randoms);

        List<Car> carList = cars.getCars();

        int movedCount = (int) carList.stream()
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