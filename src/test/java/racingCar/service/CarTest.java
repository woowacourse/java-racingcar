package racingCar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
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
    car.run(MIN_RUNNABLE_FUEL);
    Assertions.assertThat(car.getPosition()).isEqualTo(1);
  }

  @Test
  void run_failure() {
    car.run(MIN_RUNNABLE_FUEL-1);
    Assertions.assertThat(car.getPosition()).isEqualTo(0);
  }

}