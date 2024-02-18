package racing;

import java.util.List;
import java.util.Scanner;
import racing.domain.RacingGame;
import racing.dto.RacingResults;
import racing.view.CarNameInputView;
import racing.view.InputGuideOutputView;
import racing.view.RacingMaxTurnInputView;
import racing.view.RacingResultOutputView;
import util.RandomGenerator;
import util.RetryHelper;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<String> carNames = getCarNames(scanner);
    int maxTurn = getMaxTurn(scanner);
    RacingGame racingGame = new RacingGame(carNames, maxTurn);
    RacingResults racingResults = racingGame.run(new RandomGenerator());
    RacingResultOutputView.printResult(racingResults);
  }

  private static List<String> getCarNames(Scanner scanner) {
    RetryHelper carNameInputManager = new RetryHelper(5);
    return carNameInputManager.retry(
        () -> {
          InputGuideOutputView.printInputCarNames();
          return CarNameInputView.getNameFromConsole(scanner);
        });
  }

  private static int getMaxTurn(Scanner scanner) {
    RetryHelper maxTurnInputManager = new RetryHelper(5);
    return maxTurnInputManager.retry(
        () -> {
          InputGuideOutputView.printInputMaxRacingTurn();
          return RacingMaxTurnInputView.getMaxTurnFromConsole(scanner);
        });
  }
}
