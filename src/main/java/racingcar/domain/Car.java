package racingcar.domain;

import racingcar.exception.RacingCarErrorMessage;

public class Car {

  public static final int MIN_RUNNABLE_FUEL = 4;
  private final String name;
  private int position = 0;

  public Car(final String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name.length() < 1 || name.length() > 5) {
      throw new IllegalStateException(RacingCarErrorMessage.CAR_NAME_LENGTH.message());
    }
  }

  public void run(int fuel) {
    if (runnable(fuel)) {
      this.position++;
    }
  }

  private boolean runnable(final int fuel) {
    return fuel >= MIN_RUNNABLE_FUEL;
  }

  public int position() {
    return position;
  }

  public String name() {
    return name;
  }
}
