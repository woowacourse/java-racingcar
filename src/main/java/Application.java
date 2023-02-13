import contoller.RaceGame;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class Application {

  public static void main(String[] args) {
    final List<String> carNames = repeat(InputView::readCarNames);
    final int roundCount = repeat(InputView::readTrialNum);

    final RaceGame raceGame = new RaceGame(carNames, roundCount);
    raceGame.race();
    OutputView.printWinners(raceGame.pickWinner());
  }

  private static <T> T repeat(Supplier<T> inputReader) {
    try {
      return inputReader.get();
    } catch (Exception e) {
      OutputView.printErrorMessage(e);
      return repeat(inputReader);
    }
  }
}
