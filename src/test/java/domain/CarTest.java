package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름 예외처리 테스트")
    @Test
    void creatCarTeat() {
        assertThatThrownBy(() -> {
            Car car = new Car("aaaaaa");
        });
    }

    @DisplayName("자동차의 위치 이동 테스트")
    @Test
    void moveTest() {
        Car car = new Car("car");
        car.move(5);

        int result = car.getPosition();

        assertThat(result).isEqualTo(1);
    }
}