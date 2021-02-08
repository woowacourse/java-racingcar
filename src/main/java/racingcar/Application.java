package racingcar;

import racingcar.domain.Participants;
import racingcar.domain.RacingManager;
import racingcar.domain.RacingResult;
import racingcar.domain.RandomSupplier;
import racingcar.domain.Turn;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

  public static void main(String[] args) {
    Participants participants = InputView.getNames();
    Turn turn = InputView.getTurn();

    RacingManager racingManager = new RacingManager(participants, turn, new RandomSupplier());

    RacingResult racingResult = racingManager.start();
    OutputView.printProgressResult(racingResult.getLog());
    OutputView.printWinner(racingResult.decideWinner());
  }
}
