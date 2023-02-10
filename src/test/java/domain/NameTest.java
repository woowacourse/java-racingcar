package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import exception.NameIsOutOfBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @DisplayName("이름의 길이가 1보다 작거나 5보다 크면 Exception이 발생")
    @ValueSource(strings = {"", "abcdef"})
    void incorrectNameLengthTest(final String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(NameIsOutOfBoundException.class);
    }

    @ParameterizedTest
    @DisplayName("이름의 길이가 1과 5사이 이면 정상적으로 Name 객체가 생성")
    @ValueSource(strings = {"a", "abcde"})
    void correctNameLengthTest(final String name) {
        assertDoesNotThrow(() -> new Name(name));
    }
}
