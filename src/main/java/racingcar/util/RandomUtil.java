package racingcar.util;

import java.util.Random;

public class RandomUtil {

  private static final int EXCLUSIVE_BOUND_CORRECTION_VALUE = 1;
  private static final int MINIMUM = 0;
  private static final int MAXIMUM = 9;
  private static final String RANGE_OVER_ERROR_MESSAGE = "최소, 최대 범위의 입력을 확인해 주세요";

  private static final Random RANDOM = new Random();

  public static int generateRandomNumber() {
    int randomNumber =
        RANDOM.nextInt(MAXIMUM - MINIMUM + EXCLUSIVE_BOUND_CORRECTION_VALUE) + MINIMUM;
    validRange(randomNumber);
    return randomNumber;
  }

  // FIXME google java style 메소드 명은 동사로 시작해야 한다.(5.2.3)
  // FIXME IllegalArgumentException가 사용되는 것이 적절한가?
  private static void validRange(int randomNumber) {
    if (randomNumber > MAXIMUM || randomNumber < MINIMUM) {
      throw new IllegalArgumentException(RANGE_OVER_ERROR_MESSAGE);
    }
  }
}
