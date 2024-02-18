package racing.domain;

import static racing.domain.Cars.CAR_MOVE_THRESHOLD;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

  @Test
  @DisplayName("레이스 테스트")
  void move() {
    List<Integer> racingCondition = List.of(CAR_MOVE_THRESHOLD - 1, CAR_MOVE_THRESHOLD);
    Cars testCars = new Cars(List.of(new Car(0, "testA"), new Car(0, "testB")));
    testCars.move(racingCondition);
    Map<String, Integer> carsStatus = testCars.getCarsStatus();
    Assertions.assertThat(carsStatus)
        .isEqualTo(Map.of("testA", 0, "testB", 1));
  }

  @Test
  @DisplayName("제일 멀리 움직인 자동차를 제대로 추출하는지 확인")
  void getMax() {
    Car max1 = new Car(1, "b");
    Car max2 = new Car(1, "c");
    Cars cars = new Cars(List.of(new Car(0, "a"), max1, max2));
    List<Car> realMax = cars.getMax();
    List<Car> expectedMax = List.of(max1, max2);
    Assertions.assertThat(realMax)
        .containsExactlyInAnyOrderElementsOf(expectedMax);
  }
}