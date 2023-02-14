package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RandomNumberValidatorTest {

    @Nested
    @DisplayName("비정상 입력값이 들어온 케이스")
    class invalidInputTest {

        @ParameterizedTest
        @ValueSource(ints = {-1, 10})
        @DisplayName("0 미만 9 초과의 수가 들어오면 예외처리 한다.")
        void invalidNumberTest(int input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> RandomNumberValidator.validate(input))
                    .withMessageStartingWith(RandomNumberValidator.Message.EXCEPTION_NUMBER_RANGE.getMessage());
        }

    }

    @Nested
    @DisplayName("정상 입력값이 들어온 케이스")
    class validInputTest {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
        @DisplayName("올바른 입력값이 들어왔을 때 잘 검증하는지 검사한다.")
        void 정상_입력(int input) {
            assertThatCode(() -> RandomNumberValidator.validate(input))
                    .doesNotThrowAnyException();
        }

    }
}
