package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

  @DisplayName("new Position() 테스트")
  @Test
  public void 생성자_test() throws Exception {
    Position position = new Position();
    assertThat(position.get()).isEqualTo(0);
  }

  @DisplayName("increase() 테스트")
  @Test
  public void increase_test() throws Exception {
    Position position = new Position();
    position.increase();
    assertThat(position.get()).isEqualTo(1);
  }

  @DisplayName("compareTo() 테스트")
  @Test
  public void compareTo_test() throws Exception {
    Position position = new Position();
    Position testPosition = new Position();
    position.increase();
    assertThat(position.compareTo(testPosition)).isGreaterThan(0);
  }
}
