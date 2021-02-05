package racingcar.domain;

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
    participants = new Participants("pobi", "sp");
    racingResult = new RacingResult(participants);
  }

  @Test
  void appendLog() {
    String expectedLog = "pobi : -" + ENTER + "sp : -" + ENTER + ENTER;
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
    assertThat(racingResult.getWinner()).isEqualTo(expectedLog);
  }

  @Test
  void getWinner_우승자_여러명() {
    String expectedLog = "pobi, sp";
    assertThat(racingResult.getWinner()).isEqualTo(expectedLog);
  }
}