package racingcar.controller;

import java.util.Objects;
import java.util.Optional;
import racingcar.message.ErrorMessage;
import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;

    public InputController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Cars getCars() {
        Optional<Cars> cars = Optional.empty();
        while (Objects.equals(cars, Optional.empty())) {
            cars = readCars();
        }
        return cars.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.get()));
    }

    private Optional<Cars> readCars() {
        try {
            String carNames = inputView.readCarNames();
            return Optional.of(Cars.from(carNames));
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return Optional.empty();
        }
    }

    public Round getRound() {
        Optional<Round> round = Optional.empty();
        while (Objects.equals(round, Optional.empty())) {
            round = readRound();
        }
        return round.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.get()));
    }

    private Optional<Round> readRound() {
        try {
            String tryRound = inputView.readTryRound();
            return Optional.of(Round.from(tryRound));
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return Optional.empty();
        }
    }
}
