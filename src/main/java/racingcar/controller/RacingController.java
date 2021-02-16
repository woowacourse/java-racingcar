package racingcar.controller;

import racingcar.domain.CarNamesInput;
import racingcar.domain.MoveCountInput;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.RacingGame;
import racingcar.domain.rule.CarMoveRandomCondition;
import racingcar.view.InputView;
import racingcar.view.InputViewMessages;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private String carNamesInput;
    private String moveCountInput;

    public void run() {
        Cars cars = null;

        try {
            cars = getInputFromUserAndStartGameAndGetResult();
        } catch (RuntimeException e) {
            controlError(e.getMessage());
            return;
        }

        OutputView.printWinner(cars);
    }

    private void controlError(String errorMessage) {
        OutputView.print(errorMessage);
        run();
    }

    private Cars getInputFromUserAndStartGameAndGetResult() {
        getCarNamesAndMoveCountFromUser();
        return startGameAndGetGameResult();
    }


    private void getCarNamesAndMoveCountFromUser() {
        carNamesInput = InputView.inputFormUser(InputViewMessages.REQUEST_CAR_NAME);
        moveCountInput = InputView.inputFormUser(InputViewMessages.REQUEST_MOVE_COUNT);
    }

    private List<Car> makeCarListFromCarNames(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, new CarMoveRandomCondition()))
                .collect(Collectors.toList());

    }

    private Cars startGameAndGetGameResult() {
        Cars cars = createCarsFromCarNamesInput();
        int moveCount = MoveCountInput.valueOf(moveCountInput).getMoveCount();
        return doGameAndGetResult(cars, moveCount);
    }

    private Cars doGameAndGetResult(Cars cars, int moveCount) {
        OutputView.print(OutputView.EXECUTION_RESULT);

        RacingGame racingGame = new RacingGame(cars, moveCount);

        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCarStates(racingGame.getCars());
        }

        return racingGame.getCars();
    }


    private Cars createCarsFromCarNamesInput() {
        List<String> carNames = CarNamesInput.valueOf(carNamesInput).getCarNames();

        return Cars.of(makeCarListFromCarNames(carNames));
    }
}
