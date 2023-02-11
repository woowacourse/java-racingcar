package view.input;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;
    private ByteArrayOutputStream outputMessage;

    void setInputStream(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView = new InputView();
    }

    void setOutput() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @DisplayName("입력이 빈 문자열이 아닐때까지 입력을 받는다")
    @Test
    void input_empty() {
        setInputStream("\n\nb");
        setOutput();
        String inputExist = inputView.getInputUntilExist();
        assertThat(
            "입력값이 없습니다. 다시 입력해주세요\n입력값이 없습니다. 다시 입력해주세요\n")
            .isEqualTo(outputMessage.toString());
        assertThat(inputExist).isEqualTo("b");
    }

    @DisplayName("공백으로만 이루어져 있는 문자열은 모든 공백이 무시된다.")
    @Test
    void input_strip_all_blank() {
        setInputStream("             \n\n\nb");
        setOutput();
        String inputExist = inputView.getInputUntilExist();
        assertThat(
            "입력값이 없습니다. 다시 입력해주세요\n입력값이 없습니다. 다시 입력해주세요\n입력값이 없습니다. 다시 입력해주세요\n")
            .isEqualTo(outputMessage.toString());
        assertThat(inputExist).isEqualTo("b");
    }
}
