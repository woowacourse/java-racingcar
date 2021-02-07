package racingcar.controller;

import racingcar.domain.CarNamesInput;
import racingcar.domain.MoveCountInput;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.RacingGame;
import racingcar.domain.rule.RandomMoveCondition;
import racingcar.domain.util.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private String carNamesInput;
    private String moveCountInput;

    public void run() {
        GameResult gameResult;

        try {
            gameResult = getInputFromUserAndStartGameAndGetResult();
        } catch (RuntimeException e) {
            controlError(e);
            return;
        }

        printGameResult(gameResult);
    }

    private void controlError(RuntimeException runtimeException) {
        OutputView.printError(runtimeException);
        run();
    }

    private GameResult getInputFromUserAndStartGameAndGetResult() {
        getCarNamesAndMoveCountFromUser();

        return startGameAndGetGameResult();
    }

    private void getCarNamesAndMoveCountFromUser() {
        OutputView.printRequestCarName();
        carNamesInput = InputView.requestCarName();

        OutputView.printRequestMoveCount();
        moveCountInput = InputView.requestMoveCount();
    }

    private GameResult startGameAndGetGameResult() {
        Cars cars = createCarsFromCarNamesInput();
        int moveCount = MoveCountInput.valueOf(moveCountInput).getMoveCount();

        RacingGame racingGame = new RacingGame(cars, moveCount);

        return racingGame.start();
    }


    private Cars createCarsFromCarNamesInput() {
        List<String> carNames = CarNamesInput.valueOf(carNamesInput).getCarNames();

        return Cars.of(makeCarListFromCarNames(carNames));
    }

    private List<Car> makeCarListFromCarNames(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, new RandomMoveCondition(new RandomNumber())))
                .collect(Collectors.toList());

    }

    private void printGameResult(GameResult gameResult) {
        OutputView.printExecutionResult(gameResult.getExecutionResult());
        OutputView.printWinners(gameResult.getWinners());
    }
}