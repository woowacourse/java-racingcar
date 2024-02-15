package model;

import constant.Exception;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

  private final List<Car> cars;

  public Game(List<String> carsName) {
    validateDuplicate(carsName);
    this.cars = convertToCar(carsName);
  }

  private void validateDuplicate(List<String> carsName) {
    int originCount = carsName.size();
    int distinctCount = (int) carsName.stream().distinct().count();
    if (originCount != distinctCount) {
      throw new IllegalArgumentException(Exception.DUPLICATE.toString());
    }
  }

  private List<Car> convertToCar(List<String> carsName) {
    return carsName.stream().map(Car::new).toList();
  }

  public List<Car> proceed(List<Integer> randomNumbers) {
    for (int i = 0; i < randomNumbers.size(); i++) {
      applyStatus(randomNumbers.get(i), cars.get(i));
    }
    return new ArrayList<>(cars);
  }

  private void applyStatus(int randomNumber, Car car) {
    if (MoveStatus.decide(randomNumber).equals(MoveStatus.FORWARD)) {
      car.forward();
      return;
    }
    car.stop();
  }

  public List<Car> findWinners() {
    int winnersScore = Collections.max(cars.stream().map(Car::getForwardCount).toList());
    return cars.stream().filter(car -> car.getForwardCount() == winnersScore).toList();
  }

  public int getParticipantsSize() {
    return cars.size();
  }
}
