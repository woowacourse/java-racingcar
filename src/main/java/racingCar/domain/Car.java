package racingCar.domain;

public class Car {

  private final static int MIN_RUNNABLE_FUEL = 4;
  private final String name;
  private int position = 0;
  private int fuel = 0;

  public Car(String name) {
    this.name = name;
  }

  public void run() {
    if (isRunnable(fuel)) {
      this.position++;
    }
    fuel = 0;
  }

  public void fillInFuel(int fuel) {
    this.fuel = fuel;
  }

  private boolean isRunnable(int fuel) {
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
