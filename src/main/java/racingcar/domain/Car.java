package racingcar.domain;

public class Car implements Comparable<Car> {

  public static final int MIN_RUNNABLE_FUEL = 4;
  private final Name name;
  private int position = 0;

  public Car(final String name) {
    this.name = new Name(name);
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

  public boolean isSamePosition(final Car car) {
    return position == car.position;
  }

  public String getName() {
    return name.get();
  }

  @Override
  public int compareTo(Car car) {
    return position - car.position;
  }
}
