package view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView getInputView(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        return new InputView(inputStream);
    }

    @Test
    @DisplayName("이름에 특수문자가 포함되면 예외를 발생하는가")
    void read_car_name_contain_special_test() {
        String text = "asd,###";
        InputView inputView = getInputView(text);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(inputView::readCarNames);
    }

    @Test
    @DisplayName("이름에 한글 포함되면 예외를 발생하는가")
    void read_car_name_contain_kr_test() {
        String text = "가나,아";
        InputView inputView = getInputView(text);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(inputView::readCarNames);
    }
}
