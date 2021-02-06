package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

  private Car car;

  @BeforeEach
  void init() {
    this.car = new Car("Pobi");
  }

  @ParameterizedTest
  @CsvSource(value = {Car.MIN_RUNNABLE_FUEL + ":1", Car.MIN_RUNNABLE_FUEL - 1 + ":0"}, delimiter = ':')
  @DisplayName("최소 달릴 수 있는 연료를 차에 주입했을 때 1 만큼 전진을 하였는 지 확인")
  void run(int fuel, int expected) {
    car.fillInFulAndRun(fuel);
    assertThat(car.getPosition()).isEqualTo(expected);
  }

  @Test
  void checkFuelAfterRun() {
    car.fillInFulAndRun(Car.MIN_RUNNABLE_FUEL);
    assertThat(car.getFuel()).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "spring"})
  @DisplayName("이름 길이가 0 이하 또는 5 이상일 때 에러 확인")
  void car_name_exception(String name) {
    assertThatThrownBy(() -> new Car(name))
        .isInstanceOf(IllegalStateException.class);
  }
}