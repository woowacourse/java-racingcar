package racingcar.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;
import static racingcar.view.InputView.*;


public class InputViewTest {

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @ParameterizedTest
    @ValueSource(strings = "ab,cd,ef")
    void 이름_입력_성공(String input) {
        systemIn(input);
        String[] names = insertRightName();
        assertThat(names).contains("ab", "cd", "ef");
    }

    @ParameterizedTest
    @ValueSource(strings = "abbbbbb,cd,ef,g,h,i")
    void 이름_입력_실패(String input) {
        systemIn(input);
        assertThatThrownBy(() -> insertRightName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차는 2대 이상 5대 이하이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = "5")
    void 횟수_입력_성공(String input) {
        systemIn(input);
        int count = insertRightNumber();
        assertThat(count).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = "a")
    void 횟수_입력_실패(String input) {
        systemIn(input);
        assertThatThrownBy(() -> insertRightNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 횟수는 숫자로 입력해야 합니다.");
    }
}
