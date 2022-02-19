package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
public class InputValidatorTest {
    @Test
    public void 빈_문자열_입력_테스트() {
        assertThatThrownBy(() -> InputValidator.checkCarNamesInput(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("빈 문자열을 자동차 이름으로 입력할 수 없습니다.");
    }

    @Test
    public void 숫자가_아닌_시도_횟수_테스트() {
        assertThatThrownBy(() -> InputValidator.checkTrialCount("이브"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("시도 횟수가 숫자가 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    public void 시도_횟수_음수_혹은_0_테스트(String trial) {
        assertThatThrownBy(() -> InputValidator.checkTrialCount(trial))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("시도 횟수가 음수나 0이 될 수 없습니다.");
    }
}
