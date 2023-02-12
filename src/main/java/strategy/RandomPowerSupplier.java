package strategy;

import java.util.Random;

public class RandomPowerSupplier implements PowerSupplier {

  private static final Random random = new Random();
  private static final int MAX_POWER = 10;
  
  @Override
  public int supply() {
    return random.nextInt(MAX_POWER);
  }
}
