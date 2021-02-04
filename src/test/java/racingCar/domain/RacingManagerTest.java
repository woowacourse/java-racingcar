package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingManagerTest {

  private final int MIN_RUNNABLE_FUEL = 4;
  private Participants participants = new Participants("pobi", "spring", "on");
  private GasStation gasStation = new GasStation(() -> 5);
  private RacingManager racingManager = new RacingManager(participants, 3, gasStation);

  @Test
  void start_우승자_1명() {
    String expectedLog = "pobi";

    List<Car> cars = participants.getCars();
    cars.get(0).fillInFuel(MIN_RUNNABLE_FUEL);
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