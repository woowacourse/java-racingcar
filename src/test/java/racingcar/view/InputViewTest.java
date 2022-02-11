package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class InputViewTest {

  @Test
  public void requestCarName_이름_공백_test() throws Exception {
    String input = "";
    byte[] buf = input.getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    assertThatThrownBy(() -> InputView.requestCarName())
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void requestAttempt_시도_회수_공백_test() throws Exception {
    String input = "";
    byte[] buf = input.getBytes();
    System.setIn(new ByteArrayInputStream(buf));
    assertThatThrownBy(() -> InputView.requestAttempt())
        .isInstanceOf(RuntimeException.class);
  }
}
