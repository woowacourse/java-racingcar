package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingResultTest {

  private static final String ENTER = "\n";
  private static final int MIN_RUNNABLE_FUEL = 4;
  private Participants participants;
  private RacingResult racingResult;

  @BeforeEach
  void init() {
    participants = new Participants("pobi", "sp");
    racingResult = new RacingResult(participants);
  }

  @Test
  void appendLog() {
    //given
    String expectedLog = "pobi : -" + ENTER + "sp : -" + ENTER + ENTER;
    participants.cars().forEach(car -> car.run(MIN_RUNNABLE_FUEL));

    //when
    racingResult.appendLog();

    //then
    assertThat(racingResult.log()).isEqualTo(expectedLog);
  }

  @Test
  void getWinner_우승자_1명() {
    //given
    String expectedLog = "pobi";

    //when
    List<Car> cars = participants.cars();
    cars.get(0).run(MIN_RUNNABLE_FUEL);

    //then
    assertThat(racingResult.winner()).isEqualTo(expectedLog);
  }

  @Test
  void getWinner_우승자_여러명() {
    //given
    String expectedLog = "pobi, sp";

    //when, then
    assertThat(racingResult.winner()).isEqualTo(expectedLog);
  }
}