package model;

import constant.Exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {
  private final int NAME_LENGTH_CONDITION = 5;
  private final String name;
  private final List<CarStatus> statuses;

  public Car(String name) {
    validateNullAndEmpty(name);
    validateNameLength(name);
    this.name = name;
    this.statuses = new ArrayList<>();
  }

  private void validateNullAndEmpty(String name) {
    if (Objects.isNull(name) || name.isBlank()) {
      throw new IllegalArgumentException(Exception.CAR_NAME_NULL_BLANK.toString());
    }
  }

  private void validateNameLength(String name) {
    if (name.length() > NAME_LENGTH_CONDITION) {
      throw new IllegalArgumentException(Exception.CAR_NAME_LENGTH.toString());
    }
  }

  public void forward() {
    statuses.add(CarStatus.FORWARD);
  }

  public void stop() {
    statuses.add(CarStatus.STOP);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return Objects.equals(name, car.name) && Objects.equals(statuses, car.statuses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, statuses);
  }

  public List<CarStatus> getStatuses() {
    return new ArrayList<>(statuses);
  }

  public String getName() {
    return name;
  }

  public int getForwardCount() {
    return (int) statuses.stream().filter(carStatus -> carStatus.equals(CarStatus.FORWARD)).count();
  }
}
