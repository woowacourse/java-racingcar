package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;
    private Judge judge;

    @BeforeEach
    void before() {
        judge = new Judge();
        car = new Car("test", judge);
    }

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void 차량_전진_테스트(int driveCount) {
        //given
        final int DRIVING_DISTANCE = 1;
        //when
        for (int count = 0; count < driveCount; count++) {
            car.drive();
        }
        //then
        int drivenDistance = car.getDrivenDistance();
        org.assertj.core.api.Assertions.assertThat(drivenDistance).isEqualTo(driveCount);
    }
}
