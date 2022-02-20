package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("정상적인 이름들을 받은 경우")
    void validateCarName() {
        assertThat(new Car("car1").getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("null값이 차 이름으로 들어온 경우")
    void validateCarNameNull() {
        assertThatThrownBy(() -> {
            new Car(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 스트링이 차 이름으로 들어온 경우")
    void validateCarNameEmpty() {
        assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차 이름이 다섯글자를 초과한 경우")
    void validateCarNameOverFiveLength() {
        assertThatThrownBy(() -> {
            new Car("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차가 전진하는 경우")
    void moveCar() {
        Car car = new Car("test");
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("차가 전진하지 않는 경우")
    void stopCar() {
        Car car = new Car("test");
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}