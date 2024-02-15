package racing.domain;

import static racing.domain.Cars.CAR_MOVE_THRESHOLD;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

  @Test
  @DisplayName("레이스 테스트")
  void move() {
    List<Integer> racingCondition = List.of(CAR_MOVE_THRESHOLD - 1, CAR_MOVE_THRESHOLD);
    Cars testCars = new Cars(List.of(new Car(0, "test"), new Car(0, "testB")));
    Cars expectedCars = new Cars(List.of(new Car(0, "test"), new Car(1, "testB")));
    testCars.move(racingCondition);

    Assertions.assertThat(testCars)
        .isEqualTo(expectedCars);
  }
}