package racingcar.domain;

import java.util.function.Supplier;

public class RacingManager {

  private final Participants participants;
  private final int round;
  private final Supplier<Integer> fuel;

  public RacingManager(final Participants participants, final int round, final Supplier<Integer> fuel) {
    this.participants = participants;
    this.round = round;
    this.fuel = fuel;
  }

  public RacingResult start() {
    RacingResult racingResult = new RacingResult(participants);
    for (int i = 0; i < round; i++) {
      race(racingResult);
    }
    return racingResult;
  }

  private void race(final RacingResult racingResult) {
    participants.cars().forEach(car -> car.run(fuel.get()));
    racingResult.appendLog();
  }

}
