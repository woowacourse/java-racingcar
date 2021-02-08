package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingManagerTest {

  private static final int MIN_RUNNABLE_FUEL = 4;
  private Participants participants;
  private RacingManager racingManager;

  @BeforeEach
  void init() {
    participants = new Participants("pobi", "sp", "on");
    racingManager = new RacingManager(participants, new Round(3), () -> MIN_RUNNABLE_FUEL);
  }

  @Test
  void start_우승자_1명() {
    //given
    String expectedLog = "pobi";

    //when
    List<Car> cars = participants.cars();
    cars.get(0).run(MIN_RUNNABLE_FUEL);
    RacingResult racingResult = racingManager.start();

    //then
    assertThat(racingResult.winner()).isEqualTo(expectedLog);
  }

  @Test
  void start_우승자_여러명() {
    //given
    String expectedLog = "pobi, sp, on";

    //when
    RacingResult racingResult = racingManager.start();

    //then
    assertThat(racingResult.winner()).isEqualTo(expectedLog);
  }
}