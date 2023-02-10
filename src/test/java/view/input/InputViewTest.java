package view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.ErrorMessages;

class InputViewTest {

    private InputView inputView;

    void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView = new InputView();
    }

    @DisplayName("입력이 빈 문자열일 때 오류를 던진다")
    @Test
    void input_empty() {
        setInput("\nb");
        assertThatThrownBy(inputView::getCarNames).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessages.EMPTY_INPUT.getMessage());
    }

    @DisplayName("공백으로만 이루어져 있는 문자열은 모든 공백이 무시된다.")
    @Test
    void input_strip_all_blank() {
        setInput("              \nb");
        assertThatThrownBy(inputView::getCarNames).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessages.EMPTY_INPUT.getMessage());
    }

    @DisplayName("입력 앞뒤에 존재하는 공백은 무시한다.")
    @Test
    void input_strip_word_exist() {
        setInput("       a      \nb");
        String input = inputView.getCarNames();
        assertThat(input).isEqualTo("a");
    }
}
