package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    @Test
    void validateNameSizeTest() {
        Assertions.assertThatThrownBy(() -> new Car("애쉬릴리엘라"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자");
    }

    @DisplayName("자동차 이름이 공백이면 예외가 발생한다")
    @Test
    void validateBlankNameTest() {
        Assertions.assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백");
    }

    @DisplayName("자동차 이름에 공백이 포함되면 공백을 삭제한다")
    @Test
    void validateBlankDeletionTest() {
        Car car = new Car("애 쉬");

        Assertions.assertThat(car.getCarName()).isEqualTo("애쉬");
    }

    @DisplayName("자동차 위치가 1씩 증가한다")
    @Test
    void incLocationTest() {
        Car car = new Car("애쉬");
        car.incLocation();

        Assertions.assertThat(car.getLocation()).isEqualTo(1);
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
