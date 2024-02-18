package racing.domain;

import static racing.domain.Cars.CAR_MOVE_THRESHOLD;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.dto.RacingResult;
import racing.dto.RacingResults;

class RacingGameTest {

  @Test
  @DisplayName("게임 실행 테스트")
  void run() {
    List<String> carNames = List.of("testA", "testB", "testC");
    RacingGame racingGame = new RacingGame(carNames, 1);
    RacingResults racingResults = racingGame.run(
        size -> List.of(CAR_MOVE_THRESHOLD, CAR_MOVE_THRESHOLD - 1, CAR_MOVE_THRESHOLD));
    RacingResults expected = new RacingResults(List.of(
        new RacingResult(Map.of("testA", 1, "testB", 0, "testC", 1))));
    Assertions.assertThat(racingResults.isSameResult(expected))
        .isTrue();
  }
}