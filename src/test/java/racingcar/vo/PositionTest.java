package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {

  @Test
  public void 생성자_test() throws Exception {
    Position position = new Position();
    assertThat(position.get()).isEqualTo(0);
  }

  @Test
  public void increase_test() throws Exception {
    Position position = new Position();
    position.increase();
    assertThat(position.get()).isEqualTo(1);
  }
}
