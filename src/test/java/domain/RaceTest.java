package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racing.domain.car.Car;
import racing.domain.race.Race;
import racing.domain.race.WinnerJudge;

class RaceTest {
    @Nested
    @DisplayName("이름 중복 검증기능")
    class DuplicatedNameTest {
        @Test
        @DisplayName("이름이 중복으로 입력되었을 때 예외 발생")
        void throwExceptionWhenDuplicateNameExists() {
            Assertions.assertThatThrownBy(() -> new Race(List.of("rosie", "hong", "rosie")))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("우승자를 판별 기능은")
    class GetWinnersTest {
        private Race race;
        private WinnerJudge mockWinnerJudge;


        @Test
        @DisplayName("우승자를 반드시 포함해서 알려준다")
        void shouldContainWinners() {
            // given
            mockWinnerJudge = cars -> List.of(new Car("rosie"));
            race = new Race(List.of("rosie", "hong"), mockWinnerJudge);

            // when
            List<Car> winners = race.getWinners();

            //then
            assertThat(winners.stream().map(Car::getName).collect(Collectors.toList())).contains("rosie");
        }

        @Test
        @DisplayName("우승자가 아닌 사람을 포함하지 않고 알려준다.")
        void shouldNotContainNonWinners() {
            // given
            mockWinnerJudge = cars -> List.of(new Car("rosie"));
            race = new Race(List.of("rosie", "hong"), mockWinnerJudge);

            // when
            List<Car> winners = race.getWinners();

            //then
            assertThat(winners.stream().map(Car::getName).collect(Collectors.toList())).doesNotContain("hong");
        }
    }
}