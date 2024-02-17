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
}
