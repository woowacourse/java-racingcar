package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    @DisplayName("자동차들이 움직였는지 확인한다.")
    void getMaxDistanceDetail() {
        final Cars cars = Cars.from(List.of(Car.of("포비", 1), Car.of("커비", 2)));
        MovementGenerator movementGenerator = new AlwaysMoveGenerator();

        cars.move(movementGenerator);
        cars.move(movementGenerator);

        assertThat(cars).isEqualTo(Cars.from(List.of(Car.of("포비", 3), Car.of("커비", 4))));
    }

    @Test
    @DisplayName("최대 거리인 자동차들를 구한다")
    void getMaxDistance() {
        final Car pobi = Car.of("포비", 1);
        final Car kirby = Car.of("커비", 10);
        final Car jonge = Car.of("종이", 10);
        final Cars cars = Cars.from(List.of(pobi, kirby, jonge));

        assertThat(cars.getMaxDistanceCars()).containsExactly(kirby, jonge);
    }

    static class AlwaysMoveGenerator implements MovementGenerator {

        @Override
        public Movement generate() {
            return Movement.MOVE;
        }
    }
}
