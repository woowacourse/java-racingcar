package domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
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

    @DisplayName("자동차의 position 비교 테스트")
    @Nested
    class GetNameIfSamePositionTest {
        @DisplayName("position이 일치하지 않아 Optional.empty()를 반환한다.")
        @Test
        void isNotEqualPositionTest() {
            Car car = new Car(new CarName("toby"));
            Optional<String> result = car.getNameIfSamePosition(3);
            assertTrue(result.isEmpty());
        }

        @DisplayName("position이 일치하여 자동차의 이름을 반환한다.")
        @Test
        void isEqualPositionTest() {
            Car car = new Car(new CarName("toby"));
            Optional<String> result = car.getNameIfSamePosition(0);
            assertTrue(result.isPresent());
        }
    }
}
