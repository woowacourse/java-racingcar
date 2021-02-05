package racingcar.domain;

import racingcar.exception.RacingCarErrorMessage;

public class Car {

  public static final int MIN_RUNNABLE_FUEL = 4;
  private static final int MIN_NAME_LENGTH = 1;
  private static final int MAX_NAME_LENGTH = 5;
  private final String name;
  private int position = 0;
  private int fuel = 0;

  public Car(final String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
      throw new IllegalStateException(RacingCarErrorMessage.CAR_NAME.getMessage());
    }
  }

  public void run(final int fuel) {
    this.fuel = fuel;
    if (isRunnable()) {
      this.position++;
    }
    this.fuel = 0;
  }

  private boolean isRunnable() {
    return fuel >= MIN_RUNNABLE_FUEL;
  }

  public int getPosition() {
    return position;
  }

  public int getFuel() {
    return fuel;
  }

  public String getName() {
    return name;
  }
}
