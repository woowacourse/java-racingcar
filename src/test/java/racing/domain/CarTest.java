package racing.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("이름이 5글자 초과면 예외")
    void nameLengthEx() {
        assertThatThrownBy(() -> new Car("loooooongName"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}