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
  @DisplayName("이름이 없을 시 예외가 발생한다.")
  void validateNullAndEmpty(String input) {
    assertThatThrownBy(() -> new Car(input)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("이름이 6자 이상일 시 예외가 발생한다.")
  void validateNameLength() {
    String name = "abcdefg";
    assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("전진한 횟수를 알 수 있다.")
  void getForwardCount() {
    Car car = new Car("pobi");
    car.forward();
    car.stop();
    car.forward();
    assertThat(car.getForwardCount()).isEqualTo(2);
  }

}
