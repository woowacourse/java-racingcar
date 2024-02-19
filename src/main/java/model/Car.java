package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {
  private static final int POWER_THRESHOLD = 4;
  private final CarName carName;
  private final List<MoveStatus> movingHistory;

  public Car(String name) {
    this.carName = new CarName(name);
    this.movingHistory = new ArrayList<>();
  }

  public void move(int power) {
    if (power >= POWER_THRESHOLD) {
      movingHistory.add(MoveStatus.FORWARD);
      return;
    }
    movingHistory.add(MoveStatus.STOP);
  }

  public int countOfForward() {
    return (int) movingHistory.stream()
            .filter(carStatus -> carStatus.equals(MoveStatus.FORWARD))
            .count();
  }

  public String getName() {
    return carName.getName();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return Objects.equals(carName, car.carName) && Objects.equals(movingHistory, car.movingHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName, movingHistory);
  }
}