package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarTest {

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("이름은 존재해야 한다.")
  void validateNullAndEmpty(String input) {
    assertThatThrownBy(() -> new Car(input)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("이름은 5자 이하만 가능하다.")
  void validateNameLength() {
    String name = "abcdefg";
    assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("경주 현황을 기록할 수 있다.")
  void getStatues() {
    Car car = create();
    assertThat(car.getStatuses())
        .containsExactly(MoveStatus.FORWARD, MoveStatus.STOP, MoveStatus.FORWARD);
  }

  @Test
  @DisplayName("전진한 횟수를 알 수 있다.")
  void getForwardCount() {
    Car car = create();
    assertThat(car.getForwardCount()).isEqualTo(2);
  }

  private Car create() {
    Car car = new Car("pobi");
    car.forward();
    car.stop();
    car.forward();
    return car;
  }
}
