package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AttemptTest {

  @Test
  public void 생성자_test() throws Exception {
    String input = "3";
    Attempt attempt = new Attempt(input);
    assertThat(attempt.get()).isEqualTo(3);
  }
}
