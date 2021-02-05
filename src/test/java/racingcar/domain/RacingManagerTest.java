package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingManagerTest {

  private Participants participants;
  private GasStation gasStation;
  private RacingManager racingManager;

  @BeforeEach
  void init() {
    participants = new Participants("pobi", "spring", "on");
    gasStation = new GasStation(() -> Car.MIN_RUNNABLE_FUEL);
    racingManager = new RacingManager(participants, 3, gasStation);
  }

  @Test
  void start_우승자_1명() {
    String expectedLog = "pobi";

    List<Car> cars = participants.getCars();
    cars.get(0).fillInFuel(Car.MIN_RUNNABLE_FUEL);
    cars.get(0).run();

    RacingResult racingResult = racingManager.start();
    assertThat(racingResult.getWinner().getWinnerName()).isEqualTo(expectedLog);
  }

  @Test
  void start_우승자_여러명() {
    String expectedLog = "pobi, spring, on";
    RacingResult racingResult = racingManager.start();
    assertThat(racingResult.getWinner().getWinnerName()).isEqualTo(expectedLog);
  }
}