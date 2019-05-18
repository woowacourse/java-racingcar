package racingcargame.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JudgeTest {
    @Test
    void 우승자_제대로_찾아내는지_테스트() {
        List<Car> testCars = Arrays.asList(new Car("a", 10), new Car("b", 11), new Car("c", 12));
        List<Car> testWinners = Judge.decideWinners(testCars);

        assertThat(testWinners).isEqualTo(Arrays.asList(new Car("c", 12)));
    }

    @Test
    void 복수의_우승자_찾아내는지_테스트() {
        List<Car> testCars = Arrays.asList(new Car("a", 10), new Car("b", 10), new Car("c", 5));
        List<Car> testWinners = Judge.decideWinners(testCars);

        assertThat(testWinners).isEqualTo(Arrays.asList(new Car("a", 10), new Car("b", 10)));
    }
}
