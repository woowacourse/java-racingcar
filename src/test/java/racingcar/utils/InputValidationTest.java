package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("InputValidation 클래스를 테스트한다.")
class InputValidationTest {

    InputValidation validation = new InputValidation();

    @Nested
    @DisplayName("이름 문자열이 주어졌을 때 ")
    class NameTest {

        @DisplayName("옳바른 형식이면 통과한다.")
        @ParameterizedTest(name = "{index} {displayName} names={0}")
        @ValueSource(strings = {"pobi,crong,honux", "pobi"})
        void checkRightName(final String names) {
            assertDoesNotThrow(() -> validation.validateName(names));
        }

        @DisplayName("5자리 이상의 문자열이 주어지면 exception이 발생한다.")
        @ParameterizedTest(name = "{index} {displayName} names={0}")
        @ValueSource(strings = {"pobi,crong,honuxxx", "pobixxxx"})
        void checkWrongName(final String names) {
            assertThatExceptionOfType(RuntimeException.class)
                    .isThrownBy(() -> validation.validateName(names))
                    .withMessageMatching("이름은 5자리 이하만 가능합니다.");
        }
    }

    @Nested
    @DisplayName("반복할 횟수가 주어졌을 때")
    class RepeatTest {

        @DisplayName("올바른 반복 횟수면 통과한다")
        @ParameterizedTest(name = "{index} {displayName} repeats={0}")
        @ValueSource(strings = {"2", "10"})
        void checkRightRepeats(final String repeats) {
            assertDoesNotThrow(() -> validation.checkIntegerRepeats(repeats));
        }

        @DisplayName("정수가 아닌 반복 횟수 입력 값이면 exception이 발생한다")
        @ParameterizedTest(name = "{index} {displayName} repeats={0}")
        @ValueSource(strings = {"test", "asd"})
        void checkNotIntegerRepeats(final String repeats) {
            InputValidation validation = new InputValidation();
            assertThatExceptionOfType(RuntimeException.class)
                    .isThrownBy(() -> validation.checkIntegerRepeats(repeats))
                    .withMessageMatching("반복횟수는 정수만 입력 가능합니다.");
        }

        @DisplayName("음수의 반복 횟수 입력 값이면 exception이 발생한다")
        @ParameterizedTest(name = "{index} {displayName} repeats={0}")
        @ValueSource(ints = {-1, -123})
        void checkNegativeNumberRepeats(final int repeats) {
            assertThatExceptionOfType(RuntimeException.class)
                    .isThrownBy(() -> validation.checkNegativeRepeats(repeats))
                    .withMessageMatching("반복횟수는 양의 정수만 입력 가능합니다.");
        }
    }
}