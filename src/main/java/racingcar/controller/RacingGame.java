package racingcar.controller;

import static racingcar.view.OutputView.printRaceResult;
import static racingcar.view.OutputView.printWinners;

import racingcar.numbergenerator.NumberGenerator;
import racingcar.vo.Attempt;
import racingcar.vo.Cars;

public class RacingGame {

    private static final String CAR_NAME_DELIMITER = ",";

    private final UserInputRequester userInputRequester;

    public RacingGame() {
        this.userInputRequester = new UserInputRequester();
    }

    public void play(NumberGenerator numberGenerator) {
        Cars cars = createCars(splitCarNames(userInputRequester.getCarName()));
        Attempt attempt = new Attempt(userInputRequester.getAttempt());
        cars = cars.repeatRaceBy(attempt, numberGenerator);
        printRaceResult(cars.getRaceResult());
        printWinners(cars.judgeWinners());
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(CAR_NAME_DELIMITER);
    }

    private Cars createCars(String[] names) {
        return new Cars(names);
    }
}
