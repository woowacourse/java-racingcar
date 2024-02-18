package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    @Test
    void validatorTest() {
        Assertions.assertThatThrownBy(() -> new Car("애쉬릴리엘라"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자");
    }

    @DisplayName("자동차 위치가 1씩 증가한다")
    @Test
    void incLocationTest() {
        Car car = new Car("애쉬");
        car.incLocation();

        Assertions.assertThat(car.getLocation()).isEqualTo(1);
    }

    @DisplayName("자동차 이름의 공백 여부를 검사한다")
    @Test
    void inspectBlankNameTest() {
        Car car = new Car("");
        Car car2 = new Car("ash");

        Assertions.assertThat(car.isBlank()).isTrue();
        Assertions.assertThat(car2.isBlank()).isFalse();
    }

    @DisplayName("자동차 위치가 주어진 위치와 동일한지 검사한다")
    @Test
    void inspectSamePositionTest() {
        Car car = new Car("애쉬");
        car.incLocation();

        Assertions.assertThat(car.isSamePosition(1)).isTrue();
        Assertions.assertThat(car.isSamePosition(0)).isFalse();
    }
}
