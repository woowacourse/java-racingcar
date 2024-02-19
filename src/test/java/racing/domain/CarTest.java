package racing.domain;

import static racing.domain.Car.ONCE_MOVE_DISTANCE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  @DisplayName("전진시 이동 거리가 정해진 이동 거리만큼 증가하는지 확인")
  void go() {
    Car test = new Car(0, "test");
    test.go();
    Assertions.assertThat(test.getPosition())
        .isEqualTo(ONCE_MOVE_DISTANCE);
  }
}
