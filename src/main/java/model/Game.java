package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

  private final List<Car> participant;

  public Game(List<String> carNames) {
    validateDuplicate(carNames);
    this.participant = convertToCar(carNames);
  }

  private void validateDuplicate(List<String> carNames) {
    int originCount = carNames.size();
    int distinctCount = (int) carNames.stream().distinct().count();
    if (originCount != distinctCount) {
      throw new IllegalArgumentException();
    }
  }

  private List<Car> convertToCar(List<String> carNames) {
    return carNames.stream().map(Car::new).toList();
  }

  public List<Car> proceed(List<Integer> results) {
    for (int i = 0; i < results.size(); i++) {
      applyStatus(results.get(i), participant.get(i));
    }
    return new ArrayList<>(participant);
  }

  private void applyStatus(int result, Car car) {
    if (CarStatus.decide(result).equals(CarStatus.FORWARD)) {
      car.forward();
      return;
    }
    car.stop();
  }

  public List<Car> findWinners() {
    int winnersScore = Collections.max(participant.stream().map(Car::getForwardCount).toList());

    return participant.stream().filter(car -> car.getForwardCount() == winnersScore).toList();
  }

  public int getParticipantsSize() {
    return participant.size();
  }
}
