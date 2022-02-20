package racingcar.controller;

import static racingcar.view.OutputView.printOnceResultWith;
import static racingcar.view.OutputView.printRaceResult;
import static racingcar.view.OutputView.printWinners;

import racingcar.numbergenerator.NumberGenerator;
import racingcar.view.UserInputRequester;
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
        cars = repeatRaceBy(cars, attempt, numberGenerator);
        printWinners(cars.judgeWinners());
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(CAR_NAME_DELIMITER);
    }

    private Cars createCars(String[] names) {
        return new Cars(names);
    }

    private Cars repeatRaceBy(Cars cars, Attempt attempt, NumberGenerator numberGenerator) {
        printRaceResult();
        while (attempt.isLeft()) {
            cars = cars.raceAll(numberGenerator);
            printOnceResultWith(cars);
            attempt = attempt.decrease();
        }
        return cars;
    }
}
