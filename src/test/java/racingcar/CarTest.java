package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("자동차 이름으로 클래스가 생성되는지 테스트")
    void carGenerateTest() {
        String name = "pobi";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차가 전진하는지 테스트")
    void carMoveForwardTest() {
        String name = "pobi";
        Car car = new Car(name);
        car.moveForward();
        assertThat(car.isSamePosition(1)).isTrue();
    }
}