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
}
