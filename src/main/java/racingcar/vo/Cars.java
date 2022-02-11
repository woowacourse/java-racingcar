package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

  public static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차의 이름이 중복되었습니다.";
  private static final int NONE_DUPLICATION = 0;

  private List<Car> cars;

  public Cars() {
    cars = new ArrayList<>();
  }

  public void add(Car car) {
    validDuplicateCarName(car);
    cars.add(car);
  }

  private void validDuplicateCarName(Car car) {
    if (cars.stream().filter(each -> each.isSameName(car)).count() != NONE_DUPLICATION) {
      throw new RuntimeException(DUPLICATE_CAR_NAME_ERROR_MESSAGE);
    }
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
