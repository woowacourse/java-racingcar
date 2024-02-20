package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void 이름의_길이가_올바를_때_예외가_발생하지_않는다(String name) {
        // when & then
        assertDoesNotThrow(() -> new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void 이름의_길이가_올바르지_않을_때_예외가_발생한다(String name) {
        // when & then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 " + Name.MIN_NAME_LENGTH + "자 이상 "
                        + Name.MAX_NAME_LENGTH + "자 이하여야 합니다.");
    }
}
