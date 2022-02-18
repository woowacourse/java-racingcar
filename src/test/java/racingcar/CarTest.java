package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void movePosition_자동차_전진_성공(int argument) {

        //given
        Car car = new Car("car");

        //when
        car.movePosition(() -> argument >= 4);

        //then
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void movePosition_자동차_전진_실패(int argument) {

        //given
        Car car = new Car("car");

        //when
        car.movePosition(() -> argument >= 4);

        //then
        assertThat(car.getPosition()).isEqualTo(0);

    }

    @Test
    void isSamePosition_같은_포지션() {

        //given
        Car car = new Car("car");
        car.movePosition(() -> true);

        //then
        assertThat(car.isSamePosition(1)).isEqualTo(true);

    }

    @Test
    void isSamePosition_다른_포지션() {

        //given
        Car car = new Car("car");

        //when
        car.movePosition(() -> false);

        //then
        assertThat(car.isSamePosition(2)).isEqualTo(false);
    }

    @Test
    void 자동차_이름이_5자_초과일시_예외발생() {

        assertThatThrownBy(() ->
            new Car("moreThanFive")
        )
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 자동차_이름이_알파벳이_아닐시_예외발생() {
        assertThatThrownBy(() ->
            new Car("1234")
        )
            .isInstanceOf(IllegalArgumentException.class);
    }

}
