package racingcar.domain;

import java.util.function.Supplier;

public class RacingManager {

  private final Participants participants;
  private final Round round;
  private final Supplier<Integer> fuel;

  public RacingManager(final Participants participants, final Round round, final Supplier<Integer> fuel) {
    this.participants = participants;
    this.round = round;
    this.fuel = fuel;
  }

  public RacingResult start() {
    RacingResult racingResult = new RacingResult(participants);
    for (int i = 0; i < round.get(); i++) {
      race(racingResult);
    }
    return racingResult;
  }

  private void race(final RacingResult racingResult) {
    participants.cars().forEach(car -> car.run(fuel.get()));
    racingResult.appendLog();
  }

}
