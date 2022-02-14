package racingcar;

import java.util.List;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingCars racingCars = new RacingCars();
        RacingGame racingGame = new RacingGame();

        String carNames = InputView.askCarName();
        String tryCount = InputView.askTryCount();

        racingCars.join(carNames);
        racingGame.playGame(racingCars, Integer.parseInt(tryCount));

        List<String> winnerNameBucket = racingGame.getWinnersName(racingGame.getWinners(racingCars));
        OutputView.printWinners(winnerNameBucket);
    }
}
