package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import utils.DrivableNumberGenerator;
import utils.NonDrivableNumberGenerator;

class CarTest {

    @Test
    void 차량_전진_테스트() {
        //given
        final int DRIVING_DISTANCE = 1;
        Car car = new Car("test", new DrivableNumberGenerator());
        //when
        car.drive();
        //then
        assertThat(car.getDrivenDistance()).isEqualTo(DRIVING_DISTANCE);
    }

    @Test
    void 차량_정지_테스트() {
        //given
        Car car = new Car("test", new NonDrivableNumberGenerator());
        //when
        car.drive();
        //then
        assertThat(car.getDrivenDistance()).isEqualTo(0);
    }
}
