package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

  private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차의 이름이 중복되었습니다.";
  private static final String NO_SUCH_CAR_ERROR_MESSAGE = "자동차가 없습니다.";
  private static final int NONE_DUPLICATION = 0;

  private List<Car> cars;

  public Cars(String[] names) {
    cars = new ArrayList<>();
    for (String name : names) {
      Car car = new Car(new CarName(name));
      validateDuplicateCarName(car);
      cars.add(car);
    }
  }

  public RoundResults repeatRaceBy(Attempt attempt) {
    RoundResults results = new RoundResults();
    while (attempt.isLeft()) {
      results.add(raceAll());
      attempt.decrease();
    }
    return results;
  }

  private RoundResult raceAll() {
    RoundResult result = new RoundResult();
    for (Car car : cars) {
      car.move();
      result.add(car);
    }
    return result;
  }

  public Winners findWinners() {
    Car maxPositionCar = cars.stream()
        .max(Car::compareTo)
        .orElseThrow(() -> new NoSuchElementException(NO_SUCH_CAR_ERROR_MESSAGE));
    return new Winners(cars.stream()
        .filter(car -> car.isSamePosition(maxPositionCar))
        .collect(Collectors.toList()));
  }

  private void validateDuplicateCarName(Car car) {
    if (cars.stream().filter(each -> each.isSameName(car)).count() != NONE_DUPLICATION) {
      throw new RuntimeException(DUPLICATE_CAR_NAME_ERROR_MESSAGE);
    }
  }

  // FIXME 메소드 명이 isSize가 적절한가?
  // FIXME 이 메서드는 테스트에서만 사용되는데 이 메서드를 꼭 사용해서 테스트해야할까?
  public boolean isSize(int size) {
    return cars.size() == size;
  }
}
