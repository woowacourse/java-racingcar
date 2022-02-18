package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.utils.validator.CarNamesValidator;
import racingcar.utils.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private RacingGame racingGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        ready();
        start();
        result();
    }

    private void ready() {
        final List<Car> cars = createCars(inputCarNames());
        final int tryCount = inputTryCount();

        racingGame = new RacingGame(cars, tryCount);
    }

    private String[] inputCarNames() {
        try {
            String[] carNames = inputView.inputCarNames();
            CarNamesValidator.validateCarNames(carNames);
            return carNames;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    private List<Car> createCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int inputTryCount() {
        try {
            String tryCountInput = inputView.inputTryCount();
            TryCountValidator.validateTryCount(tryCountInput);
            return Integer.parseInt(tryCountInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputTryCount();
        }
    }

    private void start() {
        outputView.printResultMessage();

        while (!racingGame.isEnd()) {
            racingGame.race();
            outputView.printResult(racingGame.getCars());
        }
    }

    private void result() {
        List<String> winners = racingGame.getWinners();

        outputView.printWinners(winners);
    }
}
