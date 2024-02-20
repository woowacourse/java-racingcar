package controller;

import domain.car.Cars;
import domain.racing.RacingCount;
import dto.CarStatus;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = initCars();
        RacingCount racingCount = inputRacingCount();

        List<String> winners = racing(cars, racingCount);

        outputView.printWinners(winners);
    }

    private Cars initCars() {
        try {
            List<String> carNames = inputView.inputCarNames();

            return Cars.of(carNames);
        } catch (RuntimeException e) {
            outputView.printInputCarNamesErrorMessage();

            return initCars();
        }
    }

    private RacingCount inputRacingCount() {
        try {
            int inputRacingCount = inputView.inputRacingCount();

            return new RacingCount(inputRacingCount);
        } catch (RuntimeException e) {
            outputView.printInputRacingCountErrorMessage();

            return inputRacingCount();
        }
    }

    private List<String> racing(final Cars cars, final RacingCount racingCount) {
        outputView.printResultMessageTitle();

        int count = 1;
        while (!racingCount.isCountEnd(count++)) {
            List<CarStatus> raceResult = cars.race();
            outputView.printRacingResult(raceResult);
        }

        return cars.findWinnerNames();
    }
}
