package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RaceTest {

    @Nested
    class GetWinnersTest {
        private List<String> winners;

        @BeforeEach
        void setup() {
            Race race = new Race(List.of(new Car("rosie", 2), new Car("hong", 1)));
            winners = race.getWinners().stream().map(Car::getName).collect(Collectors.toUnmodifiableList());
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
            race.initTryTime(4);
            //when
            race.tryMoveOneTime(new TestNumberPicker(4, 1));
            //then
            //Mock 라이브러리를 이용하여 검증
        }

        @ParameterizedTest
        @DisplayName("tryMoveOneTime 메서드를 실행 후에, 시도횟수가 감소하였는지 테스트")
        @ValueSource(ints = {1, 2, 3, 4, 5})
        void tryCountDecreaseWhenExecuteTryMoveOneTime(int tryTime) {
            Race race = new Race(List.of(new Car("rosie"), new Car("hong")));
            race.initTryTime(tryTime);
            race.tryMoveOneTime(new RandomNumberPicker());
            assertThat(race).extracting("tryTime")
                    .extracting("tryTime")
                    .isEqualTo(tryTime - 1);
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
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 중복일 수 없습니다.");
        }
    }

    @Test
    @DisplayName("Race에서 초기화된 tryCount를 다시 초기화하려고 하면 Exception 발생")
    void throwExceptionWhenReInitTryCount() {
        int tryTime = 3;
        Race race = new Race(List.of(new Car("rosie"), new Car("hong")));
        race.initTryTime(tryTime);

        Assertions.assertThatThrownBy(() -> race.initTryTime(tryTime))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("시도횟수는 이미 초기화되어 있습니다.");
    }

    @Test
    @DisplayName("getStatueses 메서드는 Cars의 상태를 반환한다.")
    void getStatusesTest() {
        final Car hong = new Car("hong", 1);
        final Car rosie = new Car("rosie", 4);
        final Race race = new Race(List.of(hong, rosie));

        final List<Car> statuses = race.getStatuses();

        Assertions.assertThat(statuses)
                .extracting("name", "position")
                .containsExactly(tuple("hong", 1), tuple("rosie", 4));
    }

    @ParameterizedTest
    @DisplayName("tryTime이 0 이하면 false를 1이상이면 true를 반환한다.")
    @CsvSource(value = {"0:false", "1:true", "2:true"}, delimiter = ':')
    void canRaceTest(int time, boolean expected) {
        final Race race = new Race(List.of(new Car("hong")));
        race.initTryTime(time);

        Assertions.assertThat(race.canRace())
                .isEqualTo(expected);
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
