package util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.validator.CarNameValidator;
import util.validator.CarNameValidator.Message;

class CarNameValidatorTest {

    private CarNameValidator carNameValidator;

    @BeforeEach
    void setUp() {
        carNameValidator = new CarNameValidator();
    }


    @Nested
    class invalidInputTest {

        @ParameterizedTest
        @DisplayName("6글자 이상의 이름은 예외 처리한다.")
        @ValueSource(strings = {"이리내이리내", "반란군포비는여섯글자이상"})
        void carNameLengthTest(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> carNameValidator.validate(input))
                    .withMessage(Message.EXCEPTION_CAR_NAME_LENGTH.getMessage());
        }

    }

    @Nested
    class validInputTest {
        @Test
        void 정상_입력() {
            assertThatCode(() -> carNameValidator.validate("깃짱"))
                    .doesNotThrowAnyException();
        }

    }

}