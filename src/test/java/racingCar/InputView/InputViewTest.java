package racingCar.InputView;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.view.InputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @ParameterizedTest
    @DisplayName("콤마가 제일 앞이나 뒤에 오면 에러가 나는지 테스트")
    @ValueSource(strings = {",apple,pear", "apple,pear,"})
    void validateCarNamesInput(String input) {
        assertThatThrownBy(() -> InputView.validateCarNamesInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작이나 끝에 콤마(,)가 올 수 없습니다.");
    }

    @Test
    @DisplayName("null 또는 빈문자열이면 에러가 나는지 테스트")
    void validateNullOrEmpty() {
        assertThatThrownBy(() -> InputView.validateNullOrEmpty(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 있어야 합니다.");
        assertThatThrownBy(() -> InputView.validateNullOrEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 있어야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("1이상의 정수가 아니면 에러가 나는지 테스트")
    @ValueSource(strings = {"0", "-1", "1.0", "a"})
    void validateRaceCountInput(String input) {
        assertThatThrownBy(() -> InputView.validateRaceCountInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상의 숫자를 입력해주세요.");
    }
}
