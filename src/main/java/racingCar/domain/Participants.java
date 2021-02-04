package racingCar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {

  private final List<Car> cars;

  private Participants() {
    cars = new ArrayList<>();
  }

  public Participants(final String... names) {
    this();
    for (String name : names) {
      cars.add(new Car(name));
    }
  }

  public List<Car> getCars() {
    return Collections.unmodifiableList(cars);
  }
}
