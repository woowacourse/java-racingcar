package racingcar;

import static racingcar.view.InputView.requestAttempt;
import static racingcar.view.InputView.requestCarName;
import static racingcar.view.OutputView.printRaceResult;
import static racingcar.view.OutputView.printWinners;

import racingcar.vo.Attempt;
import racingcar.vo.Cars;

public class RacingCar {

    private static final String CAR_NAME_DELIMITER = ",";

    public void play() {
        Cars cars = createCars(splitCarNames(requestCarName()));
        Attempt attempt = new Attempt(requestAttempt());
        cars = cars.repeatRaceBy(attempt);
        printRaceResult(cars.getRaceAllResult());
        printWinners(cars.judgeWinners());
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(CAR_NAME_DELIMITER);
    }

    private Cars createCars(String[] names) {
        return new Cars(names);
    }
}
