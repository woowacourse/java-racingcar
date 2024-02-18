package model;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import response.Exception;

class CarTest {
  @Test
  @DisplayName("자동차들이 중복된 이름을 가질 시 예외가 발생한다.")
  void validateDuplicate() {
    assertThatThrownBy(() -> new Cars(of(new Car("포비"), new Car( "포비"))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Exception.DUPLICATE.getMessage());
  }
  @Test
  @DisplayName("자동차는 전진하거나 정지 할 수 있다.")
  void move(){
    Car movedCar = new Car("pobi");
    Car stoppedCar = new Car("left");
    movedCar.move(4);
    stoppedCar.move(3);
    assertAll(
            () ->assertThat(movedCar.countOfForward()).isEqualTo(1),
            () ->assertThat(stoppedCar.countOfForward()).isEqualTo(0)
    );
  }
  @Test
  @DisplayName("자동차는 전진한 횟수를 알 수 있다.")
  void countOfForward(){
    Car movedCar = new Car("pobi");
    movedCar.move(4);
    movedCar.move(4);
    assertThat(movedCar.countOfForward()).isEqualTo(2);
  }

}
