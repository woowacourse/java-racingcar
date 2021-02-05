package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

  private final List<Car> cars;

  private Participants() {
    cars = new ArrayList<>();
  }

  public Participants(final String ... names) {
    this();
    for (String name : names) {
      cars.add(new Car(name));
    }
  }

  public List<Car> getCars() {
    return Collections.unmodifiableList(cars);
  }

  public String getWinner() {
    int maxPosition = cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);

    List<Car> winners = cars.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .collect(Collectors.toList());
    return new Winner(winners).getWinnerName();
  }
}
