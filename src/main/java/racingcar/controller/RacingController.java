package racingcar.controller;

import racingcar.domain.CarNamesInput;
import racingcar.domain.MoveCountInput;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.RacingGame;
import racingcar.domain.rule.MoveCondition;
import racingcar.view.InputView;
import racingcar.view.Messages;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    public void run() {
        String carNamesInput = InputView.inputFormUser(Messages.REQUEST_CAR_NAME);
        String moveCountInput = InputView.inputFormUser(Messages.REQUEST_MOVE_COUNT);

        Cars cars = createCarsFromCarNamesInput(carNamesInput);
        GameResult gameResult = startGameAndGetGameResult(cars, moveCountInput);

        printGameResult(gameResult);
    }


    private Cars createCarsFromCarNamesInput(String carNamesInput) {
        List<String> carNames = CarNamesInput.valueOf(carNamesInput).getCarNames();

        return Cars.of(makeCarListFromCarNames(carNames));
    }

    private List<Car> makeCarListFromCarNames(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, new MoveCondition()))
                .collect(Collectors.toList());
    }

    private GameResult startGameAndGetGameResult(Cars cars, String moveCountInput) {
        int moveCount = MoveCountInput.valueOf(moveCountInput).getMoveCount();

        RacingGame racingGame = new RacingGame(cars, moveCount);

        return racingGame.start();
    }

    private void printGameResult(GameResult gameResult) {
        OutputView.print(gameResult.getExecutionResultString());
        OutputView.print(gameResult.getWinnersString());
    }
}
