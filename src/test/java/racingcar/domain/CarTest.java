package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("자동차 이름으로 클래스가 생성되는지 테스트")
    void carGenerateTest() {
        String name = "pobi";
        Car car = new Car(name, 0);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("4보다 클 때 자동차가 전진하는지 테스트")
    void carMoveForwardTest() {
        String name = "pobi";
        Car car = new Car(name, 0);
        car.move(4);
        assertThat(car.isSamePosition(1)).isTrue();
    }

    @Test
    @DisplayName("4보다 작을 때 자동차가 안움직이는지 테스트")
    void carNoMoveTest() {
        String name = "pobi";
        Car car = new Car(name, 0);
        car.move(3);
        assertThat(car.isSamePosition(0)).isTrue();
    }

    @Test
    @DisplayName("toString 이 Car의 중요 정보를 모두 담고 있는가?")
    void carToString() {
        Car car = new Car("pobi", 0);
        assertThat(car.toString()).contains("pobi", "0");
    }
}
