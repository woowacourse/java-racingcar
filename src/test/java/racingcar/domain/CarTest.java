package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {4,9})
    public void 값이_4_이상이면_전진(int value) {
        //given
        Car car = new Car(new Name("anne"));
        car.move(value);

        //when-then
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {3,0})
    public void 값이_3_이하이면_멈춤(int value) {
        //given
        Car car = new Car(new Name("anne"));
        car.move(value);

        //when-then
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }
}
