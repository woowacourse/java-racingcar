package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.RacingCount;
import racingcar.domain.RacingRule;
import racingcar.dto.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Cars cars = initCars();
        final RacingCount racingCount = inputRacingCount();

        playRacing(cars, racingCount);
        outputView.printWinners(getWinners(cars));
    }

    private Cars initCars() {
        try {
            final List<String> carNames = inputView.inputCars();
            return Cars.generateCars(carNames);
        } catch (IllegalArgumentException e) {
            outputView.printInputCarNamesErrorMessage();
            return initCars();
        }
    }

    private RacingCount inputRacingCount() {
        try {
            return new RacingCount(inputView.inputRacingCount());
        } catch (IllegalArgumentException e) {
            outputView.printInputRacingCountErrorMessage();
            return inputRacingCount();
        }
    }

    private void playRacing(final Cars cars, final RacingCount racingCount) {
        outputView.printResultMessageTitle();
        int playedCount = 0;
        while (racingCount.isFinish(playedCount)) {
            List<CarStatus> carStatuses = cars.race();
            outputView.printRacingResult(carStatuses);
            playedCount++;
        }
    }

    private List<String> getWinners(final Cars cars) {
        final RacingRule racingRule = new RacingRule();
        return racingRule.getWinners(cars)
                .stream()
                .map(Car::getName)
                .toList();
    }
}
