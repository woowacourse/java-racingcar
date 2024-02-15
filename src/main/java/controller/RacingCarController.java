package controller;

import java.io.IOException;
import model.Game;
import model.RandomGenerator;
import model.TrialCount;
import view.InputView;
import view.OutputView;

public class RacingCarController {
  private final InputView inputView;
  private final OutputView outputView;

  public RacingCarController(InputView inputView, OutputView outputView) {
    this.inputView = inputView;
    this.outputView = outputView;
  }

  public void run() throws IOException {
    Game game = new Game(inputView.inputCarsName());
    TrialCount trialCount = new TrialCount(inputView.inputTrialCount());
    outputView.printResultComment();
    while (trialCount.isRest()) {
      outputView.printResult(game.proceed(RandomGenerator.run(game.getParticipantsSize())));
      trialCount.reduce();
    }
    outputView.printWinner(game.findWinners());
  }
}
