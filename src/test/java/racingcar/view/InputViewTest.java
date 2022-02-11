package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;
import static racingcar.view.InputView.*;


public class InputViewTest {

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 이름_입력_성공() {
        systemIn("ab,cd,ef");
        String[] names = insertRightName();
        assertThat(names).contains("ab", "cd", "ef");
    }

    @Test
    void 이름_입력_실패() {
        systemIn("abbbbbb,cd,ef,g,h,i");
        assertThatThrownBy(() -> insertRightName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차는 2대 이상 5대 이하이어야 합니다.");
    }

    @Test
    void 횟수_입력_성공() {
        systemIn("5");
        int count = insertRightNumber();
        assertThat(count).isEqualTo(5);
    }

    @Test
    void 횟수_입력_실패() {
        systemIn("a");
        assertThatThrownBy(() -> insertRightNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 횟수는 숫자로 입력해야 합니다.");
    }
}
