package racingcar.controller;

import racingcar.domain.CarNamesInput;
import racingcar.domain.MoveCountInput;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.RacingGame;
import racingcar.domain.rule.MoveCondition;
import racingcar.domain.rule.RandomMoveCondition;
import racingcar.view.InputView;
import racingcar.view.Messages;
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
            controlError(e.getMessage());
            return;
        }

        printGameResult(gameResult);
    }

    private void controlError(String errorMessage) {
        OutputView.print(errorMessage);
        run();
    }

    private GameResult getInputFromUserAndStartGameAndGetResult() {
        getCarNamesAndMoveCountFromUser();

        return startGameAndGetGameResult();
    }

    private void getCarNamesAndMoveCountFromUser() {
        OutputView.print(Messages.REQUEST_CAR_NAME);
        carNamesInput = InputView.requestCarName();

        OutputView.print(Messages.REQUEST_MOVE_COUNT);
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
                .map(name -> new Car(name, new RandomMoveCondition()))
                .collect(Collectors.toList());

    }

    private void printGameResult(GameResult gameResult) {
        OutputView.print(gameResult.getExecutionResultString());
        OutputView.print(gameResult.getWinnersAsString());
    }
}
