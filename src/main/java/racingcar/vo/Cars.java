package racingcar.vo;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private List<Car> cars;

  public Cars() {
    cars = new ArrayList<>();
  }

  public void add(Car car) {
    cars.add(car);
  }

  public boolean isSize(int size) {
    return cars.size() == size;
  }

  public String repeatRace(Attempt attempt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("실행 결과").append(System.lineSeparator());
    while (attempt.isLeft()) {
      stringBuilder.append(raceOnce());
      attempt.decrease();
    }
    return stringBuilder.toString();
  }

  private String raceOnce() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Car each : cars) {
      each.move();
      stringBuilder.append(each.toString());
    }
    stringBuilder.append(System.lineSeparator());
    return stringBuilder.toString();
  }
}
