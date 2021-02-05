package racingcar.domain;

public class RacingManager {

  private final Participants participants;
  private final int turn;
  private final GasStation gasStation;

  public RacingManager(final Participants participants, final int turn, final GasStation gasStation) {
    this.participants = participants;
    this.turn = turn;
    this.gasStation = gasStation;
  }

  public RacingResult start() {
    RacingResult racingResult = new RacingResult(participants);
    for (int i = 0; i < turn; i++) {
      race(racingResult);
    }
    return racingResult;
  }

  private void race(final RacingResult racingResult) {
    participants.getCars().forEach(car -> {
      gasStation.fillInFuel(car);
      car.run();
    });
    racingResult.appendLog();
  }

}
