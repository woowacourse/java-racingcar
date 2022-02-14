package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

  private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차의 이름이 중복되었습니다.";
  private static final String RACE_RESULT_MESSAGE = "실행 결과";
  private static final String NO_SUCH_CAR_ERROR_MESSAGE = "자동차가 없습니다.";
  private static final int NONE_DUPLICATION = 0;

  private List<Car> cars;

  public Cars() {
    cars = new ArrayList<>();
  }

  public void add(Car car) {
    validDuplicateCarName(car);
    cars.add(car);
  }

  // TODO 출력 형식이 바뀌어야 한다면 View와 Cars중 어느곳이 수정되어야 하는가?
  public String repeatRaceBy(Attempt attempt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RACE_RESULT_MESSAGE).append(System.lineSeparator());
    while (attempt.isLeft()) {
      stringBuilder.append(raceAll());
      attempt.decrease();
    }
    return stringBuilder.toString();
  }

  private String raceAll() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Car car : cars) {
      car.move();
      stringBuilder.append(car.toString());
      stringBuilder.append(System.lineSeparator());
    }
    stringBuilder.append(System.lineSeparator());
    return stringBuilder.toString();
  }

  // FIXME google java style 메소드 명은 동사로 시작해야 한다.(5.2.3)
  public Winners judgeWinners() {
    Car maxPositionCar = cars.stream()
        .max(Car::compareTo)
        .orElseThrow(() -> new NoSuchElementException(NO_SUCH_CAR_ERROR_MESSAGE));
    return new Winners(cars.stream()
        .filter(car -> car.isSamePosition(maxPositionCar))
        .map(Car::getName)
        .collect(Collectors.toList()));
  }

  // FIXME google java style 메소드 명은 동사로 시작해야 한다.(5.2.3)
  private void validDuplicateCarName(Car car) {
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
