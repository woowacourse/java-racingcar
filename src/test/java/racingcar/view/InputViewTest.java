package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @DisplayName("requestCarName() 자동차 이름이 공백으로 입력되었을 때 예외 테스트")
    @Test
    public void requestCarName_Empty_test() throws Exception {
        String input = "";
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> InputView.requestCarName(scanner))
                .hasMessageContaining(ErrorMessage.INPUT_EMPTY.toString());
    }

    @DisplayName("requestAttempt() 시도 회수가 공백으로 입력되었을 때 예외 테스트")
    @Test
    public void requestAttempt_Empty_test() throws Exception {
        String input = "";
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> InputView.requestAttempt(scanner))
                .hasMessageContaining(ErrorMessage.INPUT_EMPTY.toString());
    }
}
