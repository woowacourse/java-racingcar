package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.DrivableNumberGenerator;
import utils.NonDrivableNumberGenerator;

class CarTest {

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void 차량_전진_테스트(int driveCount) {
        //given
        final int DRIVING_DISTANCE = 1;
        Car car = new Car("test", new DrivableNumberGenerator());
        //when
        for (int count = 0; count < driveCount; count++) {
            car.drive();
        }
        //then
        assertThat(car.getDrivenDistance()).isEqualTo(driveCount * DRIVING_DISTANCE);
    }

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void 차량_정지_테스트(int driveCount) {
        //given
        Car car = new Car("test", new NonDrivableNumberGenerator());
        //when
        for (int count = 0; count < driveCount; count++) {
            car.drive();
        }
        //then
        assertThat(car.getDrivenDistance()).isEqualTo(0);
    }
}
