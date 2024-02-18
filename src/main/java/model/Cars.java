package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import response.Exception;

public class Cars {

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    validateNotDuplicate(cars);
    this.cars = new ArrayList<>(cars);
  }

  private void validateNotDuplicate(List<Car> carsName) {
    int originCount = carsName.size();
    int distinctCount = (int) carsName.stream().distinct().count();
    if (originCount != distinctCount) {
      throw new IllegalArgumentException(Exception.DUPLICATE.getMessage());
    }
  }

  public Cars applyMoving() {
    for (Car car : cars) {
      car.move(new Random().nextInt(10));
    }
    return new Cars(cars);
  }

  public List<Car> participants() {
    return new ArrayList<>(cars);
  }

  public List<String> participantsNames() {
    return new ArrayList<>(cars.stream().map(Car::getName).toList());
  }

  public List<Integer> countOfForward() {
    return cars.stream().map(Car::countOfForward).toList();
  }

  public Cars findSameCountOfForward(int count) {
    return new Cars(cars.stream().filter(car -> car.countOfForward() == count).toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cars cars1 = (Cars) o;
    return Objects.equals(cars, cars1.cars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cars);
  }
}
