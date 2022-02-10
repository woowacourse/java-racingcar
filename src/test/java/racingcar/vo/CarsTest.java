package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarsTest {

  @Test
  public void add_test() throws Exception {
    String name = "name1";
    CarName carName = new CarName(name);
    Car car = new Car(carName);
    Cars cars = new Cars();
    cars.add(car);
    assertThat(cars.isSize(1)).isTrue();
  }
}
