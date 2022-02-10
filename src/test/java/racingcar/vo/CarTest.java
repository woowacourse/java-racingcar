package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

  @Test
  public void 생성자_test() throws Exception {
    String name = "name1";
    CarName carName = new CarName(name);
    Car car = new Car(carName);
    Car testCar = new Car(carName);
    assertThat(car.isSameName(testCar)).isTrue();
  }

  @Test
  public void 자동차_실행결과_출력_test() throws Exception {
    String name = "name1";
    CarName carName = new CarName(name);
    Car car = new Car(carName);
    assertThat(car.toString()).contains(name, " : ");
  }

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
