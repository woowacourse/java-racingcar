package racingcar.domain;

import racingcar.exception.RacingCarErrorMessage;

public class Car {

  public static final int MIN_RUNNABLE_FUEL = 4;
  private static final int MIN_NAME_LENGTH = 1;
  private static final int MAX_NAME_LENGTH = 5;
  private final String name;
  private int position = 0;

  public Car(final String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
      throw new IllegalStateException(RacingCarErrorMessage.CAR_NAME.getMessage());
    }
  }

  public void fillInFulAndRun(final int fuel) {
    if (isRunnable(fuel)) {
      this.position++;
    }
  }

  private boolean isRunnable(final int fuel) {
    return fuel >= MIN_RUNNABLE_FUEL;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }
}
