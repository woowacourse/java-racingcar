package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    void 쉼표_기준으로_입력값_구분() {
        String[] carNames = InputView.splitName("pobi,elly,rutgo");
        assertThat(carNames).contains("pobi");
        assertThat(carNames).contains("elly");
        assertThat(carNames).contains("rutgo");
    }

    @Test
    void 공백이_입력되었을_경우() {
        String input = "  ";
        assertThatThrownBy(() -> ValidateInput.isBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백이 입력되었습니다.");
    }
}