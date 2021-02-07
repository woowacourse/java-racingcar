package racingcar.domain;

import java.util.function.Supplier;
import racingcar.utils.RandomUtils;

public class RandomSupplier implements Supplier<Integer> {
  private static final int START_RANDOM_BOUND = 0;
  private static final int END_RANDOM_BOUND = 9;

  @Override
  public Integer get() {
    return RandomUtils.nextInt(START_RANDOM_BOUND, END_RANDOM_BOUND);
  }
}
