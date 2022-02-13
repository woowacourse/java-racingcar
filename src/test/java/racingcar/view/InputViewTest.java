package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.view.InputView.insertRightNumber;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
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
