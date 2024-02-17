package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.condition.FalseCondition;
import racingcar.condition.TrueCondition;

class CarTest {
    @Test
    @DisplayName("조건이_참일_경우_전진")
    void moveCarTest() {
        Car car = new Car("apple");

        int beforeDistance = car.getDistance();
        car.moveCar(new TrueCondition());
        int afterDistance = car.getDistance();

        Assertions.assertThat(afterDistance).isEqualTo(beforeDistance + 1);
    }

    @Test
    @DisplayName("조건이_거짓일_경우_정지")
    void stopCarTest() {
        Car car = new Car("apple");

        int beforeDistance = car.getDistance();
        car.moveCar(new FalseCondition());
        int afterDistance = car.getDistance();

        Assertions.assertThat(afterDistance).isEqualTo(beforeDistance);
    }
}
