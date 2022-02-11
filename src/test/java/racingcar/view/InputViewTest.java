package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

  @DisplayName("requestCarName() 자동차 이름이 공백으로 입력되었을 때 예외 테스트")
  @Test
  public void requestCarName_이름_공백_test() throws Exception {
    String input = "";
    byte[] buf = input.getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    assertThatThrownBy(() -> InputView.requestCarName())
        .isInstanceOf(RuntimeException.class);
  }

  @DisplayName("requestAttempt() 시도 회수가 공백으로 입력되었을 때 예외 테스트")
  @Test
  public void requestAttempt_시도_회수_공백_test() throws Exception {
    String input = "";
    byte[] buf = input.getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    assertThatThrownBy(() -> InputView.requestAttempt())
        .isInstanceOf(RuntimeException.class);
  }
}
