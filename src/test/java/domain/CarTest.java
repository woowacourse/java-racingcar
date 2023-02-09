package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @BeforeEach
    void before() {
        car = new Car("test", 0);
    }

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void drive(int driveCount) {
        //given
        final int DRIVING_DISTANCE = 1;
        //when
        for (int count = 0; count < driveCount; count++) {
            car.drive(DRIVING_DISTANCE);
        }
        //then
        int drivenDistance = car.getDrivenDistance();
        org.assertj.core.api.Assertions.assertThat(drivenDistance).isEqualTo(driveCount);
    }
}