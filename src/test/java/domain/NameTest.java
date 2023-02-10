package domain;

import error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NameTest {

    @DisplayName("자동차 이름은 1자 이상, 5자 이하이면 통과한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "12345"})
    void test1(String value) {
        assertDoesNotThrow(() -> new Name(value));
    }

    @DisplayName("자동차 이름은 0자, 혹은 5자 초과이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void test2(String value) {
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NAME_LENGTH.getValue());
    }
}