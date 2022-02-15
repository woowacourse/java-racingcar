package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

public class InputViewTest {

  @ParameterizedTest(name = "requestCarName() 자동차 이름 공백 입력 예외 테스트")
  @EmptySource
  public void requestCarName_empty_name_input_test(String input) throws Exception {
    byte[] buf = input.getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    assertThatThrownBy(() -> InputView.requestCarName())
        .isInstanceOf(RuntimeException.class);
  }

  @ParameterizedTest(name = "requestAttempt() 시도 회수 공백 입력 예외 테스트")
  @EmptySource
  public void requestAttempt_empty_attempt_input_test(String input) throws Exception {
    byte[] buf = input.getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    assertThatThrownBy(() -> InputView.requestAttempt())
        .isInstanceOf(RuntimeException.class);
  }
}
