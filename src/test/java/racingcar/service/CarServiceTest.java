package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Digit;
import racingcar.domain.Car;
import racingcar.utils.RandomUtils;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {
    private CarService carService;

    @BeforeEach
    public void setUp() {
        carService = new CarService();
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