package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

  private static final int DEFAULT_MAX_POSITION = 0;
  private final List<Car> cars = new ArrayList<>();

  public Participants(final String... names) {
    for (String name : names) {
      cars.add(new Car(name));
    }
  }

  public List<Car> getCars() {
    return Collections.unmodifiableList(cars);
  }

  public String decideWinner() {
    int maxPosition = cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(DEFAULT_MAX_POSITION);

    List<Car> winners = cars.stream()
        .filter(car -> car.isSamePosition(maxPosition))
        .collect(Collectors.toList());
    return new Winner(winners).getWinnerName();
  }
}
