package racing.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import racing.domain.RacingGame;
import racing.domain.RandomGenerator;
import racing.dto.RacingResults;
import racing.view.CarNameInputView;
import racing.view.InputGuideOutputView;
import racing.view.RacingMaxTurnInputView;
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
      return CarNameInputView.getName(this::readFromConsole);
    });
  }

  private int getMaxTurn() {
    RetryHelper retryHelper = new RetryHelper(5);
    return retryHelper.retry(() -> {
      InputGuideOutputView.printInputMaxRacingTurn();
      return RacingMaxTurnInputView.getMaxTurn(this::readFromConsole);
    });
  }

  private String readFromConsole() {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    try {
      return bufferedReader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
