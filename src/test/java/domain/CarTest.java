package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import strategy.HighNumberGenerator;
import strategy.LowNumberGenerator;
import strategy.NumberGenerator;

class CarTest {

  private static final NumberGenerator highPowerSupplier = new HighNumberGenerator();
  private static final NumberGenerator lowPowerSupplier = new LowNumberGenerator();

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
    int highPower = highPowerSupplier.generate();
    car1.move(highPower);
    int currentPosition = car1.getPosition();
    assertThat(currentPosition).isEqualTo(2);
  }

  @Test
  void 자동차_멈춤() {
    int lowPower = lowPowerSupplier.generate();
    car1.move(lowPower);
    int currentPosition = car1.getPosition();
    assertThat(currentPosition).isEqualTo(1);
  }

  @Test
  void 자동차_위치_비교() {
    car1.move(lowPowerSupplier.generate());
    car2.move(highPowerSupplier.generate());
    assertThat(car1.compareTo(car2) < 0).isTrue();
  }
}
