package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("Test for a valid name length")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void checkLengthTest(String name) {
        assertThatCode(() -> Car.createByName(name))
            .doesNotThrowAnyException();
    }

    @DisplayName("Exception test for null name")
    @Test
    void checkNullExceptionTest() {
        assertThatThrownBy(() -> Car.createByName(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Exception test for over name length limit")
    @ParameterizedTest
    @ValueSource(strings = {"", "    ", "123456"})
    void checkLengthExceptionTest(String name) {
        assertThatThrownBy(() -> Car.createByName(name))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
