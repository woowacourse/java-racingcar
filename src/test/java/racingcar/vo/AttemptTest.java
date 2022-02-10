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

  @Test
  public void isLeft_test() throws Exception {
    String inputZero = "0";
    String inputOne = "1";
    Attempt attemptZero = new Attempt(inputZero);
    Attempt attemptOne = new Attempt(inputOne);
    assertThat(attemptZero.isLeft()).isFalse();
    assertThat(attemptOne.isLeft()).isTrue();
  }

  @Test
  public void decrease_test() throws Exception {
    String input = "3";
    Attempt attempt = new Attempt(input);
    assertThat(attempt.get()).isEqualTo(3);
    attempt.decrease();
    assertThat(attempt.get()).isEqualTo(2);
    attempt.decrease();
    assertThat(attempt.get()).isEqualTo(1);
    attempt.decrease();
    assertThat(attempt.get()).isEqualTo(0);
  }
}
