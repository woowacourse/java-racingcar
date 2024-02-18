package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.exception.ExceptionMessage.INVALID_TRY_COUNT;
import static racingcar.exception.ExceptionMessage.NOT_NULL;
import static racingcar.exception.ExceptionMessage.NOT_NULL_CAR_NAME;
import static racingcar.exception.ExceptionMessage.ONLY_POSITIVE_NUMBER;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @Nested
    @DisplayName("자동차 이름 사용자 입력 테스트")
    class CarInputTest {
        @Test
        @DisplayName("[Success] 자동차 이름을 입력하면 리스트로 반환한다.")
        void parseToList() {
            assertThat(InputView.readCarNames(() -> "pobi,crong,honux"))
                    .isEqualTo(List.of("pobi", "crong", "honux"));
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {" ", "  ", "\t", "\n"})
        @DisplayName("[Exception] 자동차 이름이 공백이나 null이면 예외를 던진다.")
        void getCarNamesByNullOrEmpty(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InputView.readCarNames(() -> input))
                    .withMessage(NOT_NULL.getMessage());
        }

        @Test
        @DisplayName("[Exception] 자동차 이름이 ','로 끝나면 예외를 던진다.")
        void getCarNamesByEndsWithComma() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InputView.readCarNames(() -> "pobi,crong,honux,"))
                    .withMessage(NOT_NULL_CAR_NAME.getMessage());
        }
    }

    @Nested
    @DisplayName("시도 횟수 사용자 입력 테스트")
    class TryCountInputTest {
        @Test
        @DisplayName("[Success] 시도 횟수를 입력하면 integer로 반환한다")
        void getTryCountToInteger() {
            assertThat(InputView.readTryCount(() -> "5"))
                    .isEqualTo(5);
        }

        @Test
        @DisplayName("[Exception] 시도 횟수로 숫자가 아닌 값을 입력할 경우 예외를 던진다.")
        void getTryCountByNotNumber() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InputView.readTryCount(() -> "a"))
                    .withMessage(ONLY_POSITIVE_NUMBER.getMessage());
        }

        @Test
        @DisplayName("[Exception] 시도 횟수가 음수면 예외를 던진다.")
        void getTryCountByNegativeInteger() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InputView.readTryCount(() -> "-1"))
                    .withMessage(ONLY_POSITIVE_NUMBER.getMessage());
        }

        @Test
        @DisplayName("[Exception] 시도 횟수가 1,000을 초과하면 예외를 던진다")
        void getTryCountByOverNumber() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InputView.readTryCount(() -> "1001"))
                    .withMessage(INVALID_TRY_COUNT.getMessage());
        }
    }
}
