package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    InputView inputView;

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    @DisplayName("시도 횟수 입력 테스트")
    void inputTryTest(String input, int result) {
        String inputs = input + "\n";

        InputStream is = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(is);

        inputView = new InputView();

        int tryCount = inputView.inputTryCount();

        assertThat(tryCount).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "", " "})
    @DisplayName("시도 횟수 입력 테스트")
    void inputExceptionTryTest(String input) {
        String inputs = input + "\n";

        InputStream is = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(is);

        inputView = new InputView();

        assertThatThrownBy(() -> {
            inputView.inputTryCount();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}