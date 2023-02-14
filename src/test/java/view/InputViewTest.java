package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputViewTest {

    private InputView inputView;

    public InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("이름 입력 성공")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, crong, honux", " pobi,     crong,    honux "})
    void carNamesSuccess(String input) {
        inputView = new InputView(generateUserInput(input));
        assertDoesNotThrow(() -> inputView.requestCarNames());
    }

}
