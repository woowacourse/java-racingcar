package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputCheckerTest {
    @ParameterizedTest
    @DisplayName("콤마가 제일 앞이나 뒤에 오면 에러가 나는지 테스트")
    @ValueSource(strings = {",apple,pear", "apple,pear,"})
    void inputValidate(String input) {
        assertThatThrownBy(() -> InputChecker.inputValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작이나 끝에 콤마(,)가 올 수 없습니다.");
    }

    @Test
    @DisplayName("null 또는 빈문자열이면 에러가 나는지 테스트")
    void inputValidate2() {
        assertThatThrownBy(() -> InputChecker.inputValidate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 있어야 합니다.");
        assertThatThrownBy(() -> InputChecker.inputValidate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 있어야 합니다.");
    }
}
