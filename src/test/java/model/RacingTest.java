package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("pobi", () -> 3);
        Car car2 = new Car("dora", () -> 4);
        Car car3 = new Car("ella", () -> 5);
        cars = new Cars(List.of(car1, car2, car3));
    }

    @Test
    void 시도횟수로_경주를_생성한다() {
        assertDoesNotThrow(() -> new Racing(3));
    }

    @Test
    void 시도횟수가_1_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Racing(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수가_0이_되면_전진이_불가하다() {
        Racing racing = new Racing(1);
        boolean before = racing.canTry();
        racing.doTry(cars);
        boolean after = racing.canTry();

        assertThat(before).isNotEqualTo(after);
    }

    @Test
    void 우승자는_한명_이상일_수_있다() {
        Racing racing = new Racing(1);
        racing.doTry(cars);
        List<String> winnerNames = racing.determineWinner(cars);

        assertThat(winnerNames.size()).isEqualTo(2);
    }
}
