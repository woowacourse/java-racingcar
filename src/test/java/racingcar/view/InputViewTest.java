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

    @Test
    void 이름이_6자_이상_입력되었을_경우() {
        String input = "pobipobi";
        assertThatThrownBy(() -> ValidateInput.isOverSixLetters(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이내로 작성해주세요.");
    }

    @Test
    void 시도_횟수가_숫자가_아닌_경우() {
        String input = "두번";
        assertThatThrownBy(() -> ValidateInput.isNotNumber(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("시도 횟수는 숫자를 입력해주세요.");
    }

    @Test
    void 시도_횟수가_양수가_아닌_경우() {
        assertThatThrownBy(() -> ValidateInput.isNotPositiveNumber(-2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양수만 입력해주세요.");
    }
}