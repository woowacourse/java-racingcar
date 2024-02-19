package model;

import static fixture.CarFixture.자동차;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    void 자동차를_한칸_전진한다() {
        // given
        Car car = 자동차();

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void 자동차를_여러칸_전진한다(int moveCount) {
        // given
        Car car = 자동차();

        // when
        IntStream.range(0, moveCount)
                .forEach(i -> car.moveForward());

        // then
        assertThat(car.getPosition()).isEqualTo(moveCount);
    }

    @Test
    void 자동차_이름이_같으면_같은_자동차이다() {
        // given
        Car car1 = 자동차("prin");
        Car car2 = 자동차("prin");

        // when & then
        assertThat(car1).isEqualTo(car2);
    }

    @Test
    void 자동차_이름이_다르면_다른_자동차이다() {
        // given
        Car car1 = 자동차("prin");
        Car car2 = 자동차("mark");

        // when & then
        assertThat(car1).isNotEqualTo(car2);
    }
}
