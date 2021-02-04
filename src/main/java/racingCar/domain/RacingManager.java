package racingCar.domain;

public class RacingManager {

  private Participants participants;
  private int turn;
  private GasStation gasStation;

  public RacingManager(Participants participants, int turn, GasStation gasStation) {
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

  private void race(RacingResult racingResult) {
    participants.getCars().forEach(car -> {
      gasStation.fillInFuel(car);
      car.run();
    });
    racingResult.appendLog();
  }

}
