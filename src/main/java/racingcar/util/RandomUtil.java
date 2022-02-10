package racingcar.util;

import java.util.Random;

public class RandomUtil {

  private static final int MINIMUM = 0;
  private static final int MAXIMUM = 9;

  private static final Random RANDOM = new Random();

  public static int createNumber() {
    int randomNumber = RANDOM.nextInt(MAXIMUM - MINIMUM + 1) + MINIMUM;
    validRange(randomNumber);
    return randomNumber;
  }

  private static void validRange(int randomNumber) {
    if (randomNumber > MAXIMUM || randomNumber < MINIMUM) {
      throw new IllegalArgumentException("최소, 최대 범위의 입력을 확인해 주세요");
    }
  }
}
