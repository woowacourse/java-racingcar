package controller;

import java.io.IOException;
import model.Game;
import model.TrialCount;
import view.InputView;
import view.OutputView;

public class RacingCarController {
  private final OutputView outputView;
  private final InputView inputView;

  public RacingCarController(InputView inputView, OutputView outputView) {
    this.outputView = outputView;
    this.inputView = inputView;
  }

  public void run() throws IOException {
    Game game = new Game(inputView.inputCarsName());
    TrialCount trialCount = new TrialCount(inputView.inputTrialCount());
    outputView.printResultComment();
    while (trialCount.isRest()) {
      outputView.printResult(game.proceed());
      trialCount.reduce();
    }
    outputView.printWinner(game.findWinners());
  }
}
