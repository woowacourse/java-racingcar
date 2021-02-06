package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {

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

  public int maxPosition() {
    return cars().stream()
        .mapToInt(Car::position)
        .max()
        .getAsInt();
  }

  public List<Car> cars() {
    return Collections.unmodifiableList(cars);
  }
}
