package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Car 는 ")
class CarTest {

    @ParameterizedTest(name = "tryMove()시 인자가 3이하일 경우 차의 위치가 1만큼 이동한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void test_1(final int number) {
        // given
        Car car = new Car("채채");

        // when
        car.tryMove(number);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest(name = "tryMove()시 인자가 3이하일 경우 차의 위치가 1만큼 이동한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void test_2(final int number) {
        // given
        Car car = new Car("채채");

        // when
        car.tryMove(number);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

}
