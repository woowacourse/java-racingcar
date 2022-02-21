package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.dto.CarsDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        gameController.createCars(InputView.inputCarNames());
        int gameCount = gameController.createGameCount(InputView.inputGameCount());

        OutputView.printGameResultTitle();
        for (int i = 0; i < gameCount; i++) {
            CarsDto carsDto = gameController.move(new RandomNumberGenerator());
            OutputView.printCarStatus(carsDto);
        }
        OutputView.printWinner(gameController.judgeWinner());
    }
}
