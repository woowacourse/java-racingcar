package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingResultTest {

  private static final String ENTER = "\n";
  private Participants participants;
  private RacingResult racingResult;

  @BeforeEach
  void init() {
    participants = new Participants("pobi", "spring");
    racingResult = new RacingResult(participants);
  }

  @Test
  void appendLog() {
    String expectedLog = "pobi : - " + ENTER + "spring : - " + ENTER + ENTER;
    participants.getCars().forEach(car -> {
      car.fillInFuel(Car.MIN_RUNNABLE_FUEL);
      car.run();
    });
    racingResult.appendLog();
    assertThat(racingResult.getLog()).isEqualTo(expectedLog);
  }

  @Test
  void getWinner_우승자_1명() {
    String expectedLog = "pobi";
    List<Car> cars = participants.getCars();
    cars.get(0).fillInFuel(Car.MIN_RUNNABLE_FUEL);
    cars.get(0).run();
    assertThat(racingResult.getWinner().getWinnerName()).isEqualTo(expectedLog);
  }

  @Test
  void getWinner_우승자_여러명() {
    String expectedLog = "pobi, spring";
    assertThat(racingResult.getWinner().getWinnerName()).isEqualTo(expectedLog);
  }
}