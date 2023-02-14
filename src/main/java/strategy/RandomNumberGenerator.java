package strategy;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

  private static final Random random = new Random();
  private static final int MAX_POWER = 10;

  @Override
  public int generate() {
    return random.nextInt(MAX_POWER);
  }
}
