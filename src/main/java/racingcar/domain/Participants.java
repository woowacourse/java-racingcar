package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

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
    Collections.sort(cars);
    Car winnerCar = cars.get(0);

    List<Car> winners = cars.stream()
        .filter(car -> car.isSamePosition(winnerCar))
        .collect(Collectors.toList());
    return new Winner(winners).getWinnerName();
  }
}
