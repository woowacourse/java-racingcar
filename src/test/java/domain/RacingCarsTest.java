package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    void 경주참여_자동차들_생성() {
        List<String> carNames = new ArrayList<>(List.of("자동차1", "자동차2"));
        RacingCars racingCars = new RacingCars(carNames);

        assertThat(racingCars.racingCars()).hasSize(carNames.size());
    }

    @Test
    void 경주참여_자동차들_생성_중복이름_예외_테스트() {
        assertThatThrownBy(() -> new RacingCars(List.of("자동차", "자동차")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주참여_자동차들_생성_차량개수_예외_테스트() {
        assertThatThrownBy(() -> new RacingCars(List.of("자동차")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 값에_따른_1회_경주_테스트() {
        RacingCars racingCars = new RacingCars(List.of("a", "b", "c"));

        racingCars.process(new TestNumberGenerator(new LinkedList<>(List.of(0, 3, 4))));

        List<Car> racedCars = racingCars.racingCars();
        assertThat(racedCars.get(0).getPosition()).isEqualTo(0);
        assertThat(racedCars.get(1).getPosition()).isEqualTo(0);
        assertThat(racedCars.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 우승자_이름_산출_테스트() {
        RacingCars racingCars = new RacingCars(List.of("a", "b", "c"));

        racingCars.process(new TestNumberGenerator(new LinkedList<>(List.of(0, 4, 9))));

        assertThat(racingCars.findHeadCarNames()).containsOnly("b", "c");
    }

    private static class TestNumberGenerator implements NumberGenerator {
        Queue<Integer> numbers;

        public TestNumberGenerator(Queue<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            Integer number = numbers.poll();
            if (number == null) {
                throw new IllegalStateException("생성 가능한 숫자가 더 이상 존재하지 않습니다.");
            }
            return number;
        }
    }
}
