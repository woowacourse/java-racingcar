package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

  private List<Car> cars;

  public Cars() {
    cars = new ArrayList<>();
  }

  public void add(Car car) {
    cars.add(car);
  }

  public boolean isSize(int size) {
    return cars.size() == size;
  }

  public String repeatRace(Attempt attempt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("실행 결과").append(System.lineSeparator());
    while (attempt.isLeft()) {
      stringBuilder.append(raceOnce());
      attempt.decrease();
    }
    return stringBuilder.toString();
  }

  private String raceOnce() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Car each : cars) {
      each.move();
      stringBuilder.append(each.toString());
      stringBuilder.append(System.lineSeparator());
    }
    stringBuilder.append(System.lineSeparator());
    return stringBuilder.toString();
  }

  public Winners getWinners() {
    Car maxPositionCar = cars.stream()
        .max(Car::compareTo)
        .orElseThrow(() -> new NoSuchElementException("car가 없어요!"));
    return new Winners(cars.stream()
        .filter(car -> car.isSamePosition(maxPositionCar))
        .map(Car::getName)
        .collect(Collectors.toList()));
  }
}
