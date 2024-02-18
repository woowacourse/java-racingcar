package domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.car.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @ParameterizedTest(name = "공백을 이름으로 사용하면 예외가 발생한다.")
    @ValueSource(strings = {"", " "})
    void illegalNameExceptionTest(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6자 이상을 이름으로 사용하면 예외가 발생한다.")
    void illegalNameExceptionTest() {
        assertThatThrownBy(() -> new CarName("zangsu"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null을 이름으로 사용하면 예외가 발생한다.")
    void nullNameExceptionTest() {
        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
