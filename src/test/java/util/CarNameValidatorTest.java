package util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import util.CarNameValidator.Message;

class CarNameValidatorTest {

    @Nested
    @DisplayName("비정상 입력값이 들어온 케이스")
    class invalidInputTest {

        @Test
        @DisplayName("경주에 참여하는 자동차가 1대 이하면 예외처리 한다.")
        void carNumberTest() {
            List<String> names = new ArrayList<>(List.of("깃짱"));
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> CarNameValidator.validate(names))
                    .withMessage(Message.EXCEPTION_CAR_NUMBER.getMessage());
        }

        @Test
        @DisplayName("6글자 이상의 이름은 예외 처리한다.")
        void carNameLengthTest() {
            List<String> names = new ArrayList<>(List.of("깃짱", "이리내이리내"));
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> CarNameValidator.validate(names))
                    .withMessage(Message.EXCEPTION_CAR_NAME_LENGTH.getMessage());
        }

    }

    @Nested
    @DisplayName("정상 입력값이 들어온 케이스")
    class validInputTest {
        @Test
        @DisplayName("올바른 입력값이 들어왔을 때 잘 작동하는지 검사한다.")
        void 정상_입력() {
            List<String> names = new ArrayList<>(List.of("깃짱", "이리내"));
            assertThatCode(() -> CarNameValidator.validate(names))
                    .doesNotThrowAnyException();
        }

    }

}
