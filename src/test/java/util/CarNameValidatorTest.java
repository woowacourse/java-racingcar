package util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import util.CarNameValidator.Message;

class CarNameValidatorTest {

    private CarNameValidator carNameValidator;

    @BeforeEach
    void setUp() {
        carNameValidator = new CarNameValidator();
    }


    @Nested
    class invalidInputTest {

        @Test
        @DisplayName("경주에 참여하는 자동차가 1대 이하면 예외처리 한다.")
        void carNumberTest() {
            List<String> names = new ArrayList<>(List.of("깃짱"));
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> carNameValidator.validate(names))
                    .withMessage(Message.EXCEPTION_CAR_NUMBER.getMessage());
        }

/*        @ParameterizedTest
        @NullAndEmptySource
        void blankNameTest(String input) {
            List<String> names = new ArrayList<>(List.of(input, "깃짱"));
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> carNameValidator.validate(names))
                    .withMessage(Message.EXCEPTION_CAR_NAME_BLANK.getMessage());
        }*/

        @Test
        @DisplayName("6글자 이상의 이름은 예외 처리한다.")
        void carNameLengthTest() {
            List<String> names = new ArrayList<>(List.of("깃짱", "이리내이리내"));
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> carNameValidator.validate(names))
                    .withMessage(Message.EXCEPTION_CAR_NAME_LENGTH.getMessage());
        }

    }

    @Nested
    class validInputTest {
        @Test
        void 정상_입력() {
            List<String> names = new ArrayList<>(List.of("깃짱", "이리내"));
            assertThatCode(() -> carNameValidator.validate(names))
                    .doesNotThrowAnyException();
        }

    }

}