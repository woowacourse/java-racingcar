package util;

import java.util.Random;

public class RandomUtil {
  private static Random random=new Random();
  private static final int BOUND=10;

  public static int getDigit(){
    return random.nextInt(BOUND);
  }
}
