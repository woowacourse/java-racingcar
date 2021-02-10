package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.RacingManager;
import racingcar.RacingResult;

class RacingManagerTest {

  private static final int MIN_RUNNABLE_FUEL = 4;
  private static final int ROUND = 3;
  private Participants participants;
  private RacingManager racingManager;

  @BeforeEach
  void init() {
    participants = new Participants("pobi", "sp", "on");
    racingManager = new RacingManager(participants, new Round(ROUND), () -> MIN_RUNNABLE_FUEL);
  }

  @Test
  void start_우승자_1명() {
    //given
    String expectedName = "pobi";

    //when
    List<Car> cars = participants.cars();
    cars.get(0).run(MIN_RUNNABLE_FUEL);
    RacingResult racingResult = racingManager.start();

    //then
    assertThat(racingResult.logByRound(ROUND).winners()).contains(expectedName);
  }

  @Test
  void start_우승자_여러명() {
    //given
    List<String> expectedName = Arrays.asList("pobi", "sp", "on");

    //when
    RacingResult racingResult = racingManager.start();

    //then
    assertThat(racingResult.logByRound(ROUND).winners()).containsAll(expectedName);
  }
}