package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import strategy.HighPowerSupplier;
import strategy.LowPowerSupplier;
import strategy.PowerSupplier;

class CarTest {

  private static final PowerSupplier highPowerSupplier = new HighPowerSupplier();
  private static final PowerSupplier lowPowerSupplier = new LowPowerSupplier();

  private Car car1;
  private Car car2;

  @BeforeEach
  void init() {
    car1 = new Car("car1");
    car2 = new Car("car2");
  }

  @Test
  void 자동차_생성() {
    assertThat(car1).isNotNull();
  }

  @Test
  void 자동차_이동() {
    car1.move(highPowerSupplier.supply());
    int currentPosition = car1.getPosition();
    assertThat(currentPosition).isEqualTo(1);
  }

  @Test
  void 자동차_멈춤() {
    car1.move(lowPowerSupplier.supply());
    int currentPosition = car1.getPosition();
    assertThat(currentPosition).isEqualTo(0);
  }

  @Test
  void 자동차_위치_비교() {
    car1.move(lowPowerSupplier.supply());
    car2.move(highPowerSupplier.supply());
    assertThat(car1.compareTo(car2) < 0).isTrue();
  }
}
