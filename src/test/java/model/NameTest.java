package model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void 이름의_길이가_올바를_때_예외가_발생하지_않는다(String name) {
        // when & then
        assertDoesNotThrow(() -> new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void 이름의_길이가_올바르지_않을_때_예외가_발생한다(String name) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Name(name));
    }
}
