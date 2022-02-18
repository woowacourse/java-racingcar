package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    private final List<String> carNames = Arrays.asList("carA", "carB", "carC", "carD");

    @Test
    @DisplayName("게임 결과 테스트")
    void checkRacingResult() {
        int round = 5;
        RacingGame racingGame = new RacingGame(carNames, round);
        Map<Integer, List<CarDto>> raceResult = racingGame.race();

        int maxPosition = raceResult.get(round - 1)
                .stream()
                .mapToInt(CarDto::getPosition)
                .max()
                .orElse(0);
        List<Car> winners = racingGame.findWinners();

        for (Car winner : winners) {
            assertThat(winner.getPosition()).isLessThanOrEqualTo(maxPosition);
        }
    }
}
