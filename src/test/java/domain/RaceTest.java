package domain;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Nested
    class judgeWinners {
        List<Car> winners;

        @BeforeEach
        void setup() {
            Race race = new Race(List.of("rosie", "hong"), new TestNumberPicker(4, 1));
            race.tryMoveOneTime();
            winners = race.judgeWinners();
        }

        @Test
        @DisplayName("반환값에 우승자가 포함되어 있는지 테스트")
        void shouldContainsWinners() {
            Assertions.assertThat(winners)
                    .containsExactly(new Car("rosie"));
        }

        @Test
        @DisplayName("반환값에 우승자가 아닌 사람이 포함되어 있지 않은지 테스트")
        void shouldNotContainNonWinners() {
            Assertions.assertThat(winners)
                    .doesNotContain(new Car("hong"));
        }
    }

    @Nested
    @DisplayName("이름 중복 검증기능")
    class duplicatedNameTest {
        @Test
        @DisplayName("이름이 중복으로 입력되었을 때 예외 발생")
        void throwExceptionWhenDuplicateNameExists() {
            Assertions.assertThatThrownBy(() -> new Race(List.of("rosie", "hong", "rosie")))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    static class TestNumberPicker implements NumberPicker {
        private final Queue<Integer> numbers = new PriorityQueue<>(Collections.reverseOrder());

        public TestNumberPicker(Integer... numbers) {
            for (Integer number : numbers) {
                this.numbers.add(number);
            }
        }

        @Override
        public int pickNumber() {
            return numbers.poll();
        }
    }
}