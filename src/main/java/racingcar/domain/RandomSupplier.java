package racingcar.domain;

import java.util.Random;
import java.util.function.Supplier;

public class RandomSupplier implements Supplier<Integer> {

  private static final int END_RANDOM_BOUND = 9;
  private static final Random RANDOM = new Random();

  @Override
  public Integer get() {
    return RANDOM.nextInt(END_RANDOM_BOUND + 1);
  }
}
