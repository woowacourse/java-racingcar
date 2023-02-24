package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @ParameterizedTest(name = "{displayName} {index} ==> name : ''{0}''")
    @ValueSource(strings = {"", "abcdef", "pobiiiiii"})
    @DisplayName("자동차 이름의 길이가 0 이하거나 5보다 클 경우 예외 발생")
    void Should_ThrowException_When_NameMoreThan6(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름의 길이는 1부터 5 사이여야 합니다.");
    }

    @ParameterizedTest(name = "{displayName} {index} ==> name : ''{0}''")
    @ValueSource(strings = {"a", "abc", "abcde"})
    @DisplayName("자동차 이름의 길이가 1 이상 5 이하인 경우 성공")
    void Should_Success_When_NameLessThan5(String name) {
        assertDoesNotThrow(() -> new Car(name));
    }

    @ParameterizedTest(name = "{displayName} {index} ==> name : ''{0}''")
    @ValueSource(strings = {" ", "abc!", "123* "})
    @DisplayName("자동차 이름이 영숫자가 아닌 경우 예외 발생")
    void Should_ThrowException_When_NameIsNotEnglishAndNumber(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 영숫자로 이루어져야 합니다.");
    }

    @ParameterizedTest(name = "{displayName} {index} ==> name : ''{0}''")
    @ValueSource(strings = {"a1", "a2cd", "ab34e"})
    @DisplayName("자동차 이름이 영숫자인 경우 성공")
    void Should_Success_When_NameIsEnglishAndNumber(String name) {
        assertDoesNotThrow(() -> new Car(name));
    }
}
