package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberMoveStrategy;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        Cars cars = new Cars(InputView.inputCarNames());
        RandomNumberMoveStrategy randomNumberMoveStrategy = new RandomNumberMoveStrategy();
        RacingGame racingGame = new RacingGame(cars, InputView.inputRounds(), randomNumberMoveStrategy);
        RacingGameController racingGameController = new RacingGameController(racingGame);

        racingGameController.proceedRacingGame();
        racingGameController.updateViewChampionNames();
    }
}
