package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameValidatorTest {

    @Test
    void checkCarNames() {
        assertThatThrownBy(() ->
            CarNameValidator.checkCarNames(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("공백일 수 없습니다.");
    }

    @Test
    void checkQuantity() {
        assertThatThrownBy(() ->
            CarNameValidator.checkQuantity(new String[]{}))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1대 이상");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"longName"})
    void checkCarName(String input) {
        assertThatThrownBy(() ->
            CarNameValidator.checkCarName(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은");
    }
}