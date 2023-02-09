package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void basicTest() {
    Car pono = new Car("pono");
    assertThat(pono).isNotNull();
  }

  @Test
  void moveGoTest() {
    Car pono = new Car("pono");
    pono.move(7);
    int currentPosition = pono.getPosition();
    assertThat(currentPosition).isEqualTo(1);
  }

  @Test
  void moveStopTest() {
    Car pono = new Car("pono");
    pono.move(3);
    int currentPosition = pono.getPosition();
    assertThat(currentPosition).isEqualTo(0);
  }
}