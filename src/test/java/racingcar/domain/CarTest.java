package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤_숫자가_4_이상인_경우_전진")
    void moveCarTest() {
        Car car = new Car("capy");
        int initDistance = car.getDistance();
        car.moveCar(5);
        int movedDistance = car.getDistance();

        Assertions.assertThat(movedDistance).isEqualTo(initDistance + 1);
    }

    @Test
    @DisplayName("랜덤_숫자가_3_이하인_경우_정지")
    void stopCarTest() {
        Car car = new Car("capy");
        int initDistance = car.getDistance();
        car.moveCar(3);
        int movedDistance = car.getDistance();

        Assertions.assertThat(movedDistance).isEqualTo(initDistance);
    }
}