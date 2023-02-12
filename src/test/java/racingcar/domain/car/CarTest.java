package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Car 는 ")
class CarTest {

    @Test
    @DisplayName("Name을 받아 생성되고 position은 0으로 초기화 된다.")
    void test_1() {
        // given
        Name name = new Name("말랑");

        // when
        Car car = new Car(name.value());

        // then
        assertThat(car.name()).isEqualTo(name);
        assertThat(car.position()).isEqualTo(Position.init());
    }

    @ParameterizedTest(name = "move() 시 들어오는 값이 3 이하(ex: {arguments})이면 멈춘다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void test_2(final int randomNumber) {
        // given
        Car car = new Car("채채");
        Position beforeMovePosition = car.position();

        // when
        car.move(randomNumber);

        // then
        assertThat(car.position()).isEqualTo(beforeMovePosition);
    }

    @ParameterizedTest(name = "move() 시 들어오는 값이 4 이상(ex: {arguments})이면 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void test_3(final int randomNumber) {
        // given
        Car car = new Car("채채");
        Position beforeMovePosition = car.position();

        // when
        car.move(randomNumber);

        // then
        assertThat(car.position()).isEqualTo(beforeMovePosition.increase());
    }

    @ParameterizedTest(name = "move() 시 들어오는 값이 0 ~ 9 사이가 아니라면(ex: {arguments}) 오류가 발생한다.")
    @ValueSource(ints = {-1, 10})
    void test_4(final int randomNumber) {
        // given
        Car car = new Car("채채");

        // when & then
        assertThatThrownBy(() -> car.move(randomNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}