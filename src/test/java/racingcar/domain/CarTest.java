package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

  private Car car;

  @BeforeEach
  void init() {
    this.car = new Car("Pobi");
  }

  @Test
  void run_success() {
    car.fillInFuel(Car.MIN_RUNNABLE_FUEL);
    car.run();
    assertThat(car.getPosition()).isEqualTo(1);
  }

  @Test
  void run_failure() {
    car.fillInFuel(Car.MIN_RUNNABLE_FUEL - 1);
    car.run();
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @Test
  void checkFuelWhenRun() {
    car.fillInFuel(Car.MIN_RUNNABLE_FUEL);
    car.run();
    assertThat(car.getFuel()).isEqualTo(0);
  }

}