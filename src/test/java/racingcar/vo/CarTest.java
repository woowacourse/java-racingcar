package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MovableNumberGenerator;
import racingcar.util.NonMovableNumberGenerator;

public class CarTest {

  @DisplayName("new CarName() 테스트")
  @Test
  public void constructor_test() throws Exception {
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
    assertThat(car.toString()).contains(name, ":");
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
    assertThat(car.compareTo(testCar)).isEqualTo(0);
  }

  @DisplayName("move() 이동이 성공하는 테스트")
  @Test
  public void move_success_test() throws Exception {
    String name = "name1";
    CarName carName = new CarName(name);
    Car car = new Car(carName);
    MovableNumberGenerator movable = new MovableNumberGenerator();
    car.move(movable.generate());
    assertThat(car.toString()).contains(name, ":");
  }

  @DisplayName("move() 이동이 실패하는 테스트")
  @Test
  public void move_fail_test() throws Exception {
    String name = "name1";
    CarName carName = new CarName(name);
    Car car = new Car(carName);
    NonMovableNumberGenerator movable = new NonMovableNumberGenerator();
    car.move(movable.generate());
    assertThat(car.toString()).contains(name, ":");
  }
}
