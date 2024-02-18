package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("자동차 이동 테스트")
    @Nested
    class MoveTest {
        @DisplayName("자동차의 파워가 4 이상이어서 자동차가 이동한다.")
        @Test
        void carMoveTest() {
            Car car = new Car(new CarName("toby"));
            int power = 6;
            car.move(power);
            Assertions.assertThat(car.getPosition()).isEqualTo(1);
        }

        @DisplayName("자동차의 파워가 4 미만이어서 자동차가 이동하지 않는다.")
        @Test
        void carDoesNotMoveTest() {
            Car car = new Car(new CarName("toby"));
            int power = 1;
            car.move(power);
            Assertions.assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
