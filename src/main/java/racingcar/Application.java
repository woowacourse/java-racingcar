package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        Cars cars = new Cars(InputView.inputCarNames());
        RacingGame racingGame = new RacingGame(cars, InputView.inputRounds());
        RacingGameController controller = new RacingGameController(cars, racingGame);
        controller.proceedRacingGame();
        controller.updateViewChampionNames();
    }
}
