package view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    @ParameterizedTest(name = "시도 횟수 입력 테스트, input = {0}, reulst = {1}")
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void inputTryTest(String input, int result) {
        String inputs = input + "\n";
        InputStream is = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(is);

        InputView inputView = new InputView();
        int tryCount = inputView.inputTryCount();

        assertThat(tryCount).isEqualTo(result);
    }

    @ParameterizedTest(name = "시도 횟수 입력 예외 발생 테스트, input = {0}")
    @ValueSource(strings = {"a", "", " ", "2147483648", "-2147483649"})
    void inputExceptionTryTest(String input) {
        String inputs = input + "\n";
        InputStream is = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(is);

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
