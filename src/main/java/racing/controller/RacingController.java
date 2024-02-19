package racing.controller;

import java.util.List;
import racing.domain.CarNameInputValidator;
import racing.domain.RacingGame;
import racing.domain.RacingMaxTurnInputValidator;
import racing.domain.RandomGenerator;
import racing.dto.RacingResults;
import racing.view.InputGuideOutputView;
import racing.view.InputView;
import racing.view.RacingResultOutputView;
import util.RetryHelper;

public class RacingController {

  public void raceStart() {
    List<String> carNames = getCarNames();
    int maxTurn = getMaxTurn();
    RacingGame racingGame = new RacingGame(carNames, maxTurn);
    RacingResults racingResults = racingGame.run(new RandomGenerator());
    RacingResultOutputView.printResult(racingResults);
  }

  private List<String> getCarNames() {
    RetryHelper retryHelper = new RetryHelper(5);
    return retryHelper.retry(() -> {
      InputGuideOutputView.printInputCarNames();
      return InputView.getInput(CarNameInputValidator::getName);
    });
  }

  private int getMaxTurn() {
    RetryHelper retryHelper = new RetryHelper(5);
    return retryHelper.retry(() -> {
      InputGuideOutputView.printInputMaxRacingTurn();
      return InputView.getInput(RacingMaxTurnInputValidator::getMaxTurn);
    });
  }
}
