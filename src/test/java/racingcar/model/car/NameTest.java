package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @Nested
    @DisplayName("from 메소드는")
    class From {
        @Nested
        @DisplayName("빈값이라면")
        class Context_with_blank {
            @Test
            @DisplayName("예외를 발생시킨다.")
            void it_throw_exception() {
                assertThatThrownBy(() -> new Name(""))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("한글자 이상 다섯글자 이하가 아니라면")
        class Context_with_out_of_range {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(strings = {"", "aaaaaa"})
            void it_throw_exception(String input) {
                assertThatThrownBy(() -> new Name(input))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("한글자 이상 다섯글자 이하 라면")
        class Context_with_fits_the_range {
            @ParameterizedTest
            @DisplayName("Name 클래스를 반환한다.")
            @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
            void it_returns_name(String input) {
                assertDoesNotThrow(() -> new Name(input));
            }
        }

        @Nested
        @DisplayName("올바른 형식의 문자열이라면")
        class Context_with_correct_format {
            @ParameterizedTest
            @DisplayName("Name 클래스를 반환한다.")
            @ValueSource(strings = {"hudi", "tonic", "a", "토닉", "후디", "123"})
            void it_returns_name(String input) {
                assertDoesNotThrow(() -> new Name(input));
            }
        }

        @Nested
        @DisplayName("올바른 형식의 문자열이 아니라면")
        class Context_with_incorrect_format {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(strings = {" ", "ton*&", "?a1"})
            void it_throw_exception(String input) {
                assertThatThrownBy(() -> new Name(input))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
