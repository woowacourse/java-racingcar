package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

// TODO: 전체적인 구조와 이름 고민해보기
public class InputController {

    private final InputView inputView;
    private final OutputView outputView;

    public InputController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Cars getCars() {
        Cars cars = null;
        while (cars == null) {
            cars = readCars();
        }
        return cars;
    }

    private Cars readCars() {
        try {
            String carNames = inputView.readCarNames();
            return Cars.from(carNames);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return null;
        }
    }

    public Round getRound() {
        Round round = null;
        while (round == null) {
            round = readRound();
        }
        return round;
    }

    private Round readRound() {
        try {
            String tryRound = inputView.readTryRound();
            return Round.from(tryRound);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return null;
        }
    }
}
