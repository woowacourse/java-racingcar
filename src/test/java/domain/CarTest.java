package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("5자 이내 이름으로 자동차를 생성한다.")
    @Test
    void carGenerateTest() {
        assertThatCode(() -> new Car("테스트")).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 5자를 초과한다.")
    @Test
    void validateCarNameLengthTest() {
        assertThatThrownBy(() -> new Car("실패하는테스트")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름에 공백을 포함하면 예외를 던진다.")
    @Test
    void validateCarNameBlankTest() {
        assertThatThrownBy(() -> new Car("실패하는 테스트")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차가 전진한다.")
    @Test
    void forwardTest() {
        Car car = new Car("test");
        car.move(4);
        assertThat(car).extracting("forward").isEqualTo(1);
    }

    @DisplayName("자동차가 멈춘다.")
    @Test
    void stopTest() {
        Car car = new Car("test");
        car.move(3);
        assertThat(car).extracting("forward").isEqualTo(0);
    }

}
