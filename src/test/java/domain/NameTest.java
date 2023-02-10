package domain;

import exception.NameIsOutOfBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @DisplayName("이름의 길이가 1이상 5이하 이면 정상동작한다.")
    @ValueSource(strings = {"abcde", "abcd", "abc","ab", "a"})
    void nameLengthOneToFive(final String name) {
        //when
        //then
        assertThatCode(() -> new Name(name))
                .doesNotThrowAnyException();
    }
}
