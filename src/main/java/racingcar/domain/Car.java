package racingcar.domain;

import racingcar.exception.RacingCarErrorMessage;

public class Car {

  public static final int MIN_RUNNABLE_FUEL = 4;
  private final String name;
  private int position = 0;
  private int fuel = 0;

  public Car(final String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name.length() < 1 || name.length() > 5) {
      throw new IllegalStateException(RacingCarErrorMessage.CAR_NAME.getMessage());
    }
  }

  public void run() {
    if (isRunnable(fuel)) {
      this.position++;
    }
    fuel = 0;
  }

  public void fillInFuel(final int fuel) {
    this.fuel = fuel;
  }

  private boolean isRunnable(final int fuel) {
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
