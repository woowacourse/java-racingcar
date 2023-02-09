package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThat(inputView.carNames()).contains("pobi", "crong", "honux");
    }

    @DisplayName("이름 입력 실패")
    @ParameterizedTest
    @ValueSource(strings = {"\n", "포비는너무멋져남자가봐도반하겠어"})
    void carNamesFail(String input) {
        inputView = new InputView(generateUserInput(input));

        assertThatThrownBy(() -> inputView.carNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차명은 1 ~ 5 글자로 입력해야합니다.");
    }

    @DisplayName("시도 횟수 성공")
    @ParameterizedTest
    @ValueSource(strings = {"5", "10"})
    void numberOfTimesSuccess(String input) {
        inputView = new InputView(generateUserInput(input));
        assertThat(inputView.numberOfTimes()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("시도 횟수 실패")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void numberOfTimesFail(String input) {
        inputView = new InputView(generateUserInput(input));

        assertThatThrownBy(() -> inputView.numberOfTimes())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상만 가능합니다.");
    }
}
