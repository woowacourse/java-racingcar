package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Cars {

  static final int CAR_MOVE_THRESHOLD = 4;

  private final List<Car> cars;

  Cars(List<Car> cars) {
    this.cars = Collections.unmodifiableList(cars);
  }

  void move(List<Integer> racingConditions) {
    for (int index = 0; index < cars.size(); index++) {
      moveEachCar(racingConditions, index);
    }
  }

  private void moveEachCar(List<Integer> racingConditions, int index) {
    Car car = cars.get(index);
    Integer racingCondition = racingConditions.get(index);
    if (racingCondition >= CAR_MOVE_THRESHOLD) {
      car.go();
      return;
    }
    car.stop();
  }

  Map<String, Integer> getCarsStatus() {
    return cars.stream()
        .collect(Collectors.toMap(Car::getName, Car::getPosition));
  }

  List<Car> getMax() {
    Car maxCar = cars.stream()
        .sorted()
        .findFirst()
        .orElseThrow();
    return cars.stream().filter(car -> car.getPosition() == maxCar.getPosition()).toList();
  }
}
