package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
// import racingCar.utils.RandomUtils;

class GasStationTest {

  @Test
  void fillInFuel_success() {
    Car car = new Car("Pobi");
    new GasStation(() -> Car.MIN_RUNNABLE_FUEL).fillInFuel(car);
    car.run();
    assertThat(car.getPosition()).isEqualTo(1);
  }

}