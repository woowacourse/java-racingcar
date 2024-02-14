package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.function.Supplier;
import org.assertj.core.api.Assertions;
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
}