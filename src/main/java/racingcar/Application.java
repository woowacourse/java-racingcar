package racingcar;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

  public static void main(String[] args) {
    Participants participants = InputView.getNames();
    Round round = InputView.getRound();
    RacingManager racingManager = new RacingManager(participants, round, new RandomSupplier());

    RacingResult racingResult = racingManager.start();

    OutputView.printProgressResult(racingResult.log());
    OutputView.printWinner(racingResult.winner());
  }
}
