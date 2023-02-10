package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    InputView inputView = InputView.getInstance();

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("자동차 이름 입력 스플릿 테스트")
    void readCarNamesSplitTest() {
        String carNames = "성하,이오,제이";
        InputStream in = generateUserInput(carNames);
        System.setIn(in);

        Assertions.assertThat(inputView.readCarNames()).containsExactly("성하", "이오", "제이");
    }
}
