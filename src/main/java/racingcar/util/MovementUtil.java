package racingcar.util;

public class MovementUtil {

  private static final int MOVE_CONDITION = 4;

  public static boolean isMoveForward(int randomNumber) {
    if (randomNumber >= MOVE_CONDITION) {
      return true;
    }
    return false;
  }

  public static int getMoveCondition() {
    return MOVE_CONDITION;
  }
}
