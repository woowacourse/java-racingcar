package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NameTest {
    @DisplayName("from 메소드는")
    @Nested
    class from {
        @ParameterizedTest
        @ValueSource(strings = {""})
        void 빈값이라면(String input) {
            assertThatThrownBy(() -> Name.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "aa"})
        void 빈값이_아니라면(String input) {
            assertDoesNotThrow(() -> Name.from(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
        void 한글자_이상_다섯글자_이하_라면(String input) {
            assertDoesNotThrow(() -> Name.from(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "abcdef"})
        void 한글자_이상_다섯글자_이하가_아니라면(String input) {
            assertThatThrownBy(() -> Name.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"hudi", "tonic", "a", "토닉", "후디", "123"})
        void 올바른_형식의_문자열이라면(String input) {
            assertDoesNotThrow(() -> Name.from(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {" ", "ton*&", "?a1"})
        void 올바른_형식의_문자열이_아니라면(String input) {
            assertThatThrownBy(() -> Name.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

}
