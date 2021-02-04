package racingCar.service;

public class Car {

  private static final int MIN_RUNNABLE_FUEL = 4;
  private final String name;
  private int position = 0;


  public Car(String name) {
    this.name = name;
  }

  public void run(int fuel) {
    if (isRunnable(fuel)) {
      this.position++;
    }
  }

  private boolean isRunnable(int fuel) {
    return false;
  }
}
