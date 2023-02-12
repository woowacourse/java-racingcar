package contoller;

import domain.RaceGame;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class RaceController {

  private static InputView inputView = new InputView();
  private static OutputView outputView = new OutputView();

  public static void main(String[] args) {
    final List<String> carNames = repeat(inputView::readCarNames);
    final int roundCount = repeat(inputView::readTrialNum);

    final RaceGame raceGame = new RaceGame(carNames, roundCount);
    raceGame.race();
    outputView.printWinners(raceGame.pickWinner());
  }

  private static <T> T repeat(Supplier<T> inputReader) {
    try {
      return inputReader.get();
    } catch (Exception e) {
      outputView.printErrorMessage(e);
      return repeat(inputReader);
    }
  }
}
