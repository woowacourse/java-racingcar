package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  @DisplayName("전진시 이동 거리가 1 증가하는지 확인")
  void go() {
    Car test = new Car(0, "test");
    test.go();
    Assertions.assertThat(test)
        .isEqualTo(new Car(1, "test"));
  }

  @Test
  @DisplayName("정지시 이동 거리가 증가하지 않는지 확인")
  void stop() {
    Car test = new Car(0, "test");
    test.stop();
    Assertions.assertThat(test)
        .isEqualTo(new Car(0, "test"));
  }
}