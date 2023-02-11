package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Nested
    class GetWinnersTest {
        private List<String> winners;

        @BeforeEach
        void setup() {
            Race race = new Race(List.of(new Car("rosie", 2), new Car("hong", 1)));
            winners = race.getWinners().stream().map(Car::getName).collect(Collectors.toList());
        }

        @Test
        @DisplayName("반환값에 우승자가 포함되어 있는지 테스트")
        void shouldContainsWinners() {
            assertThat(winners)
                    .containsExactly("rosie");
        }

        @Test
        @DisplayName("반환값에 우승자가 아닌 사람이 포함되어 있지 않은지 테스트")
        void shouldNotContainNonWinners() {
            assertThat(winners)
                    .doesNotContain("hong");
        }
    }

    @Nested
    class tryMoveOneTimeTest {
        @Test
        @DisplayName("moveOneTime")
        void moveSuccess() {
            //given
            Race race = new Race(List.of(new Car("rosie")
                    , new Car("hong")));
            //when
            race.tryMoveOneTime(new TestNumberPicker(4, 1));
            //then
            //Mock 라이브러리를 이용하여 검증
        }
    }

    @Nested
    @DisplayName("이름 중복 검증기능")
    class duplicatedNameTest {
        @Test
        @DisplayName("이름이 중복으로 입력되었을 때 예외 발생")
        void throwExceptionWhenDuplicateNameExists() {
            List<Car> cars = List.of(new Car("rosie"), new Car("hong"), new Car("rosie"));
            Assertions.assertThatThrownBy(() -> new Race(cars))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    static class TestNumberPicker implements NumberPicker {
        private final Queue<Integer> numbers = new LinkedList<>();

        public TestNumberPicker(Integer... numbers) {
            this.numbers.addAll(Arrays.asList(numbers));
        }

        @Override
        public int pickNumber() {
            return numbers.poll();
        }
    }
}
