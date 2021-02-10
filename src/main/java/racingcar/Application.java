package racingcar;

import racingcar.domain.Participants;
import racingcar.domain.RandomSupplier;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.LogToGraph;
import racingcar.view.OutputView;

public class Application {

  public static void main(String[] args) throws InterruptedException {
    Participants participants = InputView.getNames();
    Round round = InputView.getRound();
    RacingManager racingManager = new RacingManager(participants, round, new RandomSupplier());

    RacingResult racingResult = racingManager.start();

    OutputView.printStartProgress();
    for (int i = 0; i < round.get(); i++) {
      OutputView.printProgressResult(new LogToGraph(racingResult.logByRound(i + 1)));
      Thread.sleep(500); //긴장감 조성하기!!
    }
    OutputView.printWinner(racingResult.logByRound(round.get()).winners());
  }
}
