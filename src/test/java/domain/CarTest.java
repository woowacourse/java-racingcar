package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static CarAccelerator accelerator;

    @BeforeAll
    static void init() {
        accelerator = new CarAccelerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4 이상 9 이하의 값을 받으면 자동차가 이동한다")
    void moveCar(int power) {
        //given
        Car car = new Car("pobi", accelerator);
        //when
        car.moveForward(power);
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3})
    @DisplayName("4 미만의 값을 받으면 자동차가 이동하지 않는다")
    void doNotMoveCar(int power) {
        //given
        Car car = new Car("pobi", accelerator);
        //when
        car.moveForward(power);
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("엑셀을 push하면 0~9 사이의 값만 리턴한다")
    void return0To9WhenPushAccelerator() {
        //given
        Car car = new Car("pobi", accelerator);
        //when
        int actual = car.pushAccelerator();
        //then
        assertThat(actual).isBetween(CarAccelerator.MIN_ACCEL_POWER, CarAccelerator.MAX_ACCEL_POWER);
    }
}