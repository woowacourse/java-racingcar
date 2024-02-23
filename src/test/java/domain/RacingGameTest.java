package domain;

import dto.CarDto;
import dto.ResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.PowerGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 게임 테스트")
public class RacingGameTest {

    static class FixedPowerGenerator implements PowerGenerator {
        private final List<Integer> numbers;
        private Integer index = 0;

        FixedPowerGenerator(final List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int getNumber() {
            return numbers.get(index++);
        }
    }

    @Nested
    @DisplayName("레이싱 우승자 테스트")
    class RacingWinnersTest {

        @Test
        @DisplayName("우승자 여러 명인가")
        void return_multiple_winners_correctly_test() {
            // given
            final Attempts attempts = new Attempts(1);
            final String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            final List<Integer> powers = List.of(9, 0, 9, 0);
            final RacingGame racingGame = new RacingGame(carNames, new FixedPowerGenerator(powers));

            // when
            racingGame.race(attempts);
            final List<CarDto> winners = racingGame.getWinners();

            // then
            final List<CarDto> expected = List.of(new CarDto("mang", 1), new CarDto("pobi", 1));
            assertThat(winners).isEqualTo(expected);
        }

        @Test
        @DisplayName("우승자가 없는가")
        void no_winners_test() {
            // given
            final Attempts attempts = new Attempts(1);
            final String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            final List<Integer> powers = List.of(0, 0, 0, 0);
            final RacingGame racingGame = new RacingGame(carNames, new FixedPowerGenerator(powers));

            // when
            racingGame.race(attempts);
            final List<CarDto> winners = racingGame.getWinners();

            // then
            final List<CarDto> expected = List.of();
            assertThat(winners).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("레이스 과정 테스트")
    class WinnersReturnTest {

        @Test
        @DisplayName("1번 시도의 레이스가 정상적으로 실행되는가")
        void one_attempt_race_runs_correctly_test() {
            // given
            final Attempts attempts = new Attempts(1);
            final String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            final List<Integer> powers = List.of(9, 0, 9, 0);
            final RacingGame racingGame = new RacingGame(carNames, new FixedPowerGenerator(powers));

            // when
            final List<ResultDto> raceResult = racingGame.race(attempts);

            // then
            final List<ResultDto> expected = List.of(new ResultDto(List.of(new CarDto("mang", 1),
                    new CarDto("weve", 0), new CarDto("pobi", 1), new CarDto("neo", 0))));

            assertThat(raceResult).isEqualTo(expected);
        }

        @Test
        @DisplayName("2번 시도의 레이스가 정상적으로 실행되는가")
        void two_attempt_race_runs_correctly_test() {
            // given
            final Attempts attempts = new Attempts(2);
            final String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            final List<Integer> powers = List.of(9, 0, 9, 0, 9, 9, 0, 9);
            final RacingGame racingGame = new RacingGame(carNames, new FixedPowerGenerator(powers));

            // when
            final List<ResultDto> raceResult = racingGame.race(attempts);

            // then
            final List<ResultDto> expected = List.of(
                    new ResultDto(List.of(new CarDto("mang", 1), new CarDto("weve", 0),
                            new CarDto("pobi", 1), new CarDto("neo", 0))),
                    new ResultDto(List.of(new CarDto("mang", 2), new CarDto("weve", 1),
                            new CarDto("pobi", 1), new CarDto("neo", 1))));

            assertThat(raceResult).isEqualTo(expected);
        }
    }
}
