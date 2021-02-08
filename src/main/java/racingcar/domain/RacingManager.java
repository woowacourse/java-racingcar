package racingcar.domain;

import java.util.function.Supplier;

public class RacingManager {

  private final Participants participants;
  private final Turn turn;
  private final Supplier<Integer> randomFuel;

  public RacingManager(final Participants participants, final Turn turn, final Supplier<Integer> randomFuel) {
    this.participants = participants;
    this.turn = turn;
    this.randomFuel = randomFuel;
  }

  public RacingResult start() {
    RacingResult racingResult = new RacingResult(participants);
    for (int i = 0; i < turn.get(); i++) {
      race(racingResult);
    }
    return racingResult;
  }

  private void race(final RacingResult racingResult) {
    participants.getCars().forEach(car -> car.fillInFulAndRun(randomFuel.get()));
    racingResult.appendLog();
  }

}
