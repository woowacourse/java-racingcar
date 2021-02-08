package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

  private static final int DEFAULT_POSITION = 0;
  private final List<Car> cars;

  public Participants() {
    cars = new ArrayList<>();
  }

  public Participants(final String... names) {
    this();
    for (String name : names) {
      cars.add(new Car(name));
    }
  }

  public List<Car> winner() {
    int maxPosition = maxPosition();
    return cars().stream()
        .filter(car -> car.isSamePosition(maxPosition))
        .collect(Collectors.toList());
  }

  private int maxPosition() {
    return cars().stream()
        .mapToInt(Car::position)
        .max()
        .orElse(DEFAULT_POSITION);
  }

  public List<Car> cars() {
    return Collections.unmodifiableList(cars);
  }
}
