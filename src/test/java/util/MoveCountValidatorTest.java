package util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.validator.MoveCountValidator;
import util.validator.MoveCountValidator.Message;

class MoveCountValidatorTest {
    private MoveCountValidator moveCountValidator;

    @BeforeEach
    void setUp() {
        moveCountValidator = new MoveCountValidator();
    }

    @Nested
    class invalidInputTest {

        @ParameterizedTest
        @ValueSource(strings = {"한글", "moonja", "-1000", "-2322190000"})
        @DisplayName("자연수가 아닌 입력의 경우 예외 처리한다.")
        void 자연수가_아닌_입력(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> moveCountValidator.validate(input))
                    .withMessageStartingWith(Message.EXCEPTION_NUMERIC.getMessage());
        }


        @ParameterizedTest
        @ValueSource(strings = {"2222222222222222222222222222000", "1294013905724312349120948120000"})
        @DisplayName("int 범위를 초과한 입력의 경우 예외 처리한다.")
        void int_범위를_벗어난_입력(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> moveCountValidator.validate(input))
                    .withMessageStartingWith(Message.EXCEPTION_INT_RANGE.getMessage());
        }

        @Test
        @DisplayName("0을 입력하는 경우 예외 처리한다.")
        void 빵을_입력() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> moveCountValidator.validate("0"))
                    .withMessageStartingWith(Message.EXCEPTION_NUMBER_RANGE.getMessage());
        }
    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"222000", "22222000", "1000"})
        void 정상_입력(String input) {
            assertThatCode(() -> moveCountValidator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}