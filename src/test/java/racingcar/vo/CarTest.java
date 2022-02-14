package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  @DisplayName("new CarName() 테스트")
  @Test
  public void 생성자_test() throws Exception {
    String name = "name1";
    CarName carName = new CarName(name);
    Car car = new Car(carName);
    Car testCar = new Car(carName);
    assertThat(car.isSameName(testCar)).isTrue();
  }

  @DisplayName("isSamePosition() 테스트")
  @Test
  public void isSamePosition_test() throws Exception {
    String name = "name1";
    String testName = "name2";
    CarName carName = new CarName(name);
    CarName testCarName = new CarName(testName);
    Car car = new Car(carName);
    Car testCar = new Car(testCarName);
    assertThat(car.isSamePosition(testCar)).isTrue();
  }

  @DisplayName("toString() 테스트")
  @Test
  public void toString_test() throws Exception {
    String name = "name1";
    CarName carName = new CarName(name);
    Car car = new Car(carName);
    assertThat(car.toString()).contains(name, ",");
  }

  @DisplayName("compareTo() 테스트")
  @Test
  public void compareTo_test() throws Exception {
    String name = "name1";
    String testName = "name2";
    CarName carName = new CarName(name);
    CarName testCarName = new CarName(testName);
    Car car = new Car(carName);
    Car testCar = new Car(testCarName);
    while (!car.move()) {
    }
    assertThat(car.compareTo(testCar)).isGreaterThan(0);
  }
}
