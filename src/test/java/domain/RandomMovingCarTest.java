package domain;

import domain.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovingCarTest {

    @DisplayName("랜덤한 숫자가 0에서 3 사이의 숫자라면 자동차는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopTest(int number) {
        // given
        Car car = Car.createOnStart("car");
        RandomMovingCar randomMovingCar = new RandomMovingCar(car, () -> number);

        // when
        randomMovingCar.move();

        // when & then
        assertThat(randomMovingCar.getPosition())
                .isEqualTo(0);
    }

    @DisplayName("랜덤한 숫자가 4에서 9 사이의 숫자라면 자동차는 1만큼 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveTest(int number) {
        // given
        Car car = Car.createOnStart("car");
        RandomMovingCar randomMovingCar = new RandomMovingCar(car, () -> number);

        // when
        randomMovingCar.move();

        // when & then
        assertThat(randomMovingCar.getPosition())
                .isEqualTo(1);
    }
}
