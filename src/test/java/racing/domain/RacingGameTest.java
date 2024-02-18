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
    //given
    List<String> carNames = List.of("testA", "testB", "testC");
    List<Integer> racingConditions = List.of(CAR_MOVE_THRESHOLD, CAR_MOVE_THRESHOLD - 1,
        CAR_MOVE_THRESHOLD);
    RacingGame racingGame = new RacingGame(carNames, 1);
    //when
    RacingResults racingResults = racingGame.run(size -> racingConditions);
    RacingResults expected = new RacingResults(List.of(
        new RacingResult(Map.of("testA", 1, "testB", 0, "testC", 1))));
    //then
    Assertions.assertThat(racingResults.isSameResult(expected))
        .isTrue();
  }

  @Test
  @DisplayName("우승자 테스트")
  void getWinnerNames() {
    //given
    List<String> carNames = List.of("testA", "testB", "testC");
    List<Integer> racingConditions = List.of(CAR_MOVE_THRESHOLD, CAR_MOVE_THRESHOLD - 1,
        CAR_MOVE_THRESHOLD);
    List<String> expectedWinnerNames = List.of("testA", "testC");
    RacingGame racingGame = new RacingGame(carNames, 1);
    //when
    RacingResults racingResults = racingGame.run(size -> racingConditions);
    List<String> winnerNames = racingResults.getWinnerNames();
    //then
    Assertions.assertThat(winnerNames)
        .containsExactlyInAnyOrderElementsOf(expectedWinnerNames);
  }
}