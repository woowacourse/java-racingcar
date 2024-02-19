package racingcar.controller;

import racingcar.model.*;
import racingcar.view.validator.InputValidator;
import racingcar.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {
    private final InputView inputView = new InputView();
    private final InputValidator inputValidator = new InputValidator();

    public void run() {
        List<String> carNames = inputView.getCarNames();
        inputValidator.validateAvailableCarNames(carNames);
        int attemptNumber = inputView.getAttemptNumber();

        Cars cars = new Cars(carNames);
        Race race = new Race(cars, attemptNumber);
        race.runRace();
    }

}
