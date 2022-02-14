package racingcar.util;

public class MovableNumberGenerator implements NumberGenerator {

  @Override
  public int generate() {
    return MovementUtil.getMoveCondition();
  }
}
