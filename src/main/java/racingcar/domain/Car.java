package racingcar.domain;

public class Car {

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

  public boolean isSamePosition(final int position) {
    return this.position == position;
  }

  public String getName() {
    return name.getName();
  }
}
