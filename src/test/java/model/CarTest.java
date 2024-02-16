package model;

import static fixture.CarFixture.자동차;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import support.ImmovableNumberGenerator;
import support.MovableNumberGenerator;
import util.NumberGenerator;

class CarTest {
    private final NumberGenerator movableNumberGenerator = new MovableNumberGenerator();
    private final NumberGenerator immovableNumberGenerator = new ImmovableNumberGenerator();

    @Test
    void 자동차를_한칸_전진한다() {
        // given
        Car car = 자동차();

        // when
        car.moveForward(movableNumberGenerator);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void 자동차를_여러칸_전진한다(int moveCount) {
        // given
        Car car = 자동차();

        // when
        for (int i = 0; i < moveCount; i++) {
            car.moveForward(movableNumberGenerator);
        }

        // then
        assertThat(car.getPosition()).isEqualTo(moveCount);
    }

    @Test
    void 자동차를_전진하지_않는다() {
        // given
        Car car = 자동차();

        // when
        car.moveForward(immovableNumberGenerator);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_이름이_같으면_같은_자동차이다() {
        // given
        Car carPrin1 = 자동차("prin");
        Car carPrin2 = 자동차("prin");

        // when & then
        assertThat(carPrin1).isEqualTo(carPrin2);
    }

    @Test
    void 자동차_이름이_다르면_다른_자동차이다() {
        // given
        Car carPrin = 자동차("prin");
        Car carMark = 자동차("mark");

        // when & then
        assertThat(carPrin).isNotEqualTo(carMark);
    }
}
