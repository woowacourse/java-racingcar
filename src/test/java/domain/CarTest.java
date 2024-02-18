package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("자동차 이름이 5자 초과하면 예외가 발생한다")
    @Test
    void validatorTest() {
        Assertions.assertThatThrownBy(() -> new Car("애쉬릴리엘라"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자");
    }

    @DisplayName("입력된 자동차 이름이 공백이면 예외가 발생한다")
    @Test
    void blankNameTest() {
        Assertions.assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 이름");
    }

    @DisplayName("자동차 객체 생성 시 null 값이 들어오는 경우 예외가 발생한다")
    @Test
    void nullTest() {
        Assertions.assertThatThrownBy(() -> new Car(null)).isInstanceOf(NullPointerException.class).hasMessageContaining("null");
    }
}
