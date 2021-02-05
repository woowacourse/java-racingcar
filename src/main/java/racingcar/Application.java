package racingcar;

import racingcar.domain.GasStation;
import racingcar.domain.Participants;
import racingcar.domain.RacingManager;
import racingcar.domain.RacingResult;
import racingcar.utils.RandomUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

  public static void main(String[] args) {
    Participants participants = InputView.getNames();
    int turn = InputView.getTurn();
    GasStation gasStation = new GasStation(() -> RandomUtils.nextInt(0, 9));

    RacingManager racingManager = new RacingManager(participants, turn, gasStation);

    RacingResult racingResult = racingManager.start();
    OutputView.printProgressResult(racingResult.getLog());
    OutputView.printWinner(racingResult.getWinner());
  }
}
