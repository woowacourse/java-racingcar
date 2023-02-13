package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarTest {

    @Test
    @DisplayName("자동차 한 칸 전진 확인")
    void moveCheck() {
        Car car = new Car("밀리");

        car.move(4);

        assertThat(car.isSamePosition(1)).isTrue();
    }

    @Test
    @DisplayName("자동차 정지 확인")
    void stopCheck() {
        Car car = new Car("밀리");

        car.move(3);

        assertThat(car.isSamePosition(0)).isTrue();
    }

    @Test
    @DisplayName("더 많이 이동한 자동차 위치 확인")
    void findGreaterPosition() {
        Car car = new Car("밀리");

        car.move(5);
        car.move(5);
        car.move(5);

        assertThat(car.findGreaterPosition(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이름과 위치 반환 확인")
    void getResult() {
        Car car = new Car("밀리");

        car.move(5);

        assertThat(car.getResult()).isEqualTo("밀리 : -");
    }
}
