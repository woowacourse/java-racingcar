package racingcar.domain;

import java.util.Random;
import java.util.function.Supplier;

public class RandomSupplier implements Supplier<Integer> {
  private static final int END_RANDOM_BOUND = 10;

  @Override
  public Integer get() {
    return new Random().nextInt(END_RANDOM_BOUND);
  }
}
