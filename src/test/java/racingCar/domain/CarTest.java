package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

  private final static int MIN_RUNNABLE_FUEL = 4;
  private Car car;

  @BeforeEach
  void init() {
    this.car = new Car("Pobi");
  }

  @Test
  void run_success() {
    car.fillInFuel(MIN_RUNNABLE_FUEL);
    car.run();
    assertThat(car.getPosition()).isEqualTo(1);
  }

  @Test
  void run_failure() {
    car.fillInFuel(MIN_RUNNABLE_FUEL - 1);
    car.run();
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @Test
  void checkFuelWhenRun() {
    car.fillInFuel(MIN_RUNNABLE_FUEL);
    car.run();
    assertThat(car.getFuel()).isEqualTo(0);
  }

}