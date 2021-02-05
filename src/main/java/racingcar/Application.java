package racingcar;

import racingcar.domain.Participants;
import racingcar.domain.RacingManager;
import racingcar.domain.RacingResult;
import racingcar.domain.RandomSupplier;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

  public static void main(String[] args) {
    Participants participants = InputView.getNames();
    int turn = InputView.getTurn();

    RacingManager racingManager = new RacingManager(participants, turn, new RandomSupplier());

    RacingResult racingResult = racingManager.start();
    OutputView.printProgressResult(racingResult.log());
    OutputView.printWinner(racingResult.winner());
  }
}
