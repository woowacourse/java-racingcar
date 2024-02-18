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

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.readCarNames();
        });
    }

    @Test
    @DisplayName("이름에 한글 포함되면 예외를 발생하는가")
    void read_car_name_contain_kr_test() {
        String text = "가나,아";
        InputView inputView = getInputView(text);

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.readCarNames();
        });
    }

    @Test
    @DisplayName("1 미만의 시도횟수를 입력받으면 예외를 발생시키는가")
    void read_number_of_attempts_case_less_than_1_test() {
        String text = "0";
        InputView inputView = getInputView(text);

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.readNumberOfAttempts();
        });
    }

    @Test
    @DisplayName("10을 초과하는 시도횟수를 입력받으면 예외를 발생시키는가")
    void read_number_of_attempts_more_than_10_test() {
        String text = "11";
        InputView inputView = getInputView(text);

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.readNumberOfAttempts();
        });
    }
}