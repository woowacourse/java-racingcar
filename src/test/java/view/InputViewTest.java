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
        assertThat(inputView.requestCarNames()).contains("pobi", "crong", "honux");
    }

    @DisplayName("이름 입력 실패")
    @ParameterizedTest
    @ValueSource(strings = {"\n", "포비는너무멋져남자가봐도반하겠어", "s,,,,", ",,,,"})
    void carNamesFail(String input) {
        inputView = new InputView(generateUserInput(input));

        assertThatThrownBy(() -> inputView.requestCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차명은 1 ~ 5 글자로 입력해야합니다.");
    }

    @DisplayName("시도 횟수 성공")
    @ParameterizedTest
    @ValueSource(strings = {"5", "10"})
    void numberOfTimesSuccess(String input) {
        inputView = new InputView(generateUserInput(input));
        assertThat(inputView.requestNumberOfTimes()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("시도 횟수 실패 (숫자가 아닌 것을 입력)")
    @ParameterizedTest
    @ValueSource(strings = {"0  1", "asdf$1"})
    void numberOfTimesNonNumberFail(String input) {
        inputView = new InputView(generateUserInput(input));

        assertThatThrownBy(() -> inputView.requestNumberOfTimes())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @DisplayName("시도 횟수 실패 (1 미만의 입력)")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void numberOfTimesNumberRangeFail(String input) {
        inputView = new InputView(generateUserInput(input));

        assertThatThrownBy(() -> inputView.requestNumberOfTimes())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 100 사이의 숫자를 입력해주세요");
    }
}
