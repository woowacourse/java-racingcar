package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("한명의 우승자가 선정되는 경우 테스트")
    void getWinner() {
        List<Car> cars = Arrays.asList(
                new Car("a", 3), new Car("b", 2),
                new Car("c", 2), new Car("d", 1));

        assertThat(new RacingGame(cars).getWinners()).containsExactly("a");
    }

    @Test
    @DisplayName("여러명의 우승자가 선정되는 경우 테스트")
    void getWinners() {
        List<Car> cars = Arrays.asList(
                new Car("a", 3), new Car("b", 2),
                new Car("c", 3), new Car("d", 1));

        assertThat(new RacingGame(cars).getWinners()).contains("a", "c");
    }
}
