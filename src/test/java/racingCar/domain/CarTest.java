package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    private final Car car = new Car("test");

    @Test
    @DisplayName("자동차 이름이 5자 초과인 경우 예외 발생")
    void carTest_fail1() {
        String carName = "aaaaaa";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(carName);
        });
    }

    @Test
    @DisplayName("자동차 이름을 올바르게 생성한 경우")
    void carTest_success() {
        String carName = "aaa";

        assertThatNoException().isThrownBy(() -> {
            new Car(carName);
        });
    }

    @Test
    @DisplayName("3 이하의 값이 move()에 들어간 경우, 이동하지 않음")
    void moveTest_notMove() {
        int number = 3;

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("4 이상의 값이 move()에 들어간 경우, 이동")
    void moveTest_move() {
        int number = 4;

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
