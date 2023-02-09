package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void 차량_전진_테스트(int driveCount) {
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

    @Test
    void 차량_이름_toString_테스트() {
        //given
        String name = "test";
        //when
        Car car1 = new Car(name, 0);
        Car car2 = new Car(name, 1);
        //then
        Assertions.assertThat(car1.toString()).isEqualTo("test");
        Assertions.assertThat(car2.toString()).isEqualTo("test-1");
    }
}