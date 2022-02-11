package racingcar;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        RacingCars racingCars = new RacingCars();

        String userInputCarNames = InputView.askCarName();
        racingCars.join(userInputCarNames);

        racingGame.playGame(racingCars);

        String winnersName = racingGame.getWinnersName();
        OutputView.printWinners(winnersName);
    }

}
