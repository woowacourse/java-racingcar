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
}
