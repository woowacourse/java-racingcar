package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.NameIsOutOfBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @DisplayName("이름의 길이가 1보다 작거나 5보다 크면 Exception이 발생")
    @ValueSource(strings = {"", "abcdef"})
    void nameLengthUnderOneOrOverFive(final String name) {
        //when
        //then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(NameIsOutOfBoundException.class);
    }
}
