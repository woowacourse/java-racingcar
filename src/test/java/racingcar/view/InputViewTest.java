package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @Nested
    @DisplayName("자동차 이름 사용자 입력 시")
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
                    .withMessage("공백을 입력할 수 없습니다.");
        }

        @Test
        @DisplayName("[Exception] 자동차 이름이 ','로 끝나면 예외를 던진다.")
        void getCarNamesByEndsWithComma() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InputView.readCarNames(() -> "pobi,crong,honux,"))
                    .withMessage("자동차 이름에 공백을 입력할 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("시도 횟수 사용자 입력 시")
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
                    .withMessage("시도 횟수는 양의 정수를 입력해야 합니다.");
        }
    }
}

