package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MovementUtilTest {

  @Test
  public void isMoveForward_test() throws Exception {
    int moveForward = 4;
    int stop = 3;
    assertThat(MovementUtil.isMoveForward(moveForward)).isTrue();
    assertThat(MovementUtil.isMoveForward(stop)).isFalse();
  }
}
