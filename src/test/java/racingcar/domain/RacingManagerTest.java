package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingManagerTest {

  private Participants participants;
  private RacingManager racingManager;

  @BeforeEach
  void init() {
    participants = new Participants("pobi", "sp", "on");
    racingManager = new RacingManager(participants, 3, () -> Car.MIN_RUNNABLE_FUEL);
  }

  @Test
  void start_우승자_1명() {
    String expectedLog = "pobi";

    List<Car> cars = participants.cars();
    cars.get(0).run(Car.MIN_RUNNABLE_FUEL);

    RacingResult racingResult = racingManager.start();
    assertThat(racingResult.winner()).isEqualTo(expectedLog);
  }

  @Test
  void start_우승자_여러명() {
    String expectedLog = "pobi, sp, on";
    RacingResult racingResult = racingManager.start();
    assertThat(racingResult.winner()).isEqualTo(expectedLog);
  }
}