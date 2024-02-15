package controller;

import domain.CarFactory;
import domain.Cars;
import domain.RacingCount;
import domain.RacingRule;
import dto.CarStatus;
import view.InputView;
import view.OutputView;

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

        final List<String> winners = racing(cars, racingCount);

        outputView.printWinners(winners);
    }

    private Cars initCars() {
        try {
            final List<String> carNames = inputView.inputCars();

            return CarFactory.generateCars(carNames);
        } catch (IllegalArgumentException e) {
            outputView.printInputCarNamesErrorMessage();

            return initCars();
        }
    }

    private RacingCount inputRacingCount() {
        try {
            return inputView.inputRacingCount();
        } catch (IllegalArgumentException e) {
            outputView.printInputRacingCountErrorMessage();

            return inputRacingCount();
        }
    }

    private List<String> racing(final Cars cars, final RacingCount racingCount) {
        outputView.printResultMessageTitle();
        for (int i = 0; i < racingCount.getCount(); i++) {
            final List<CarStatus> raceResult = cars.race();
            outputView.printRacingResult(raceResult);
        }

        return getWinners(cars);
    }

    private List<String> getWinners(final Cars cars) {
        final RacingRule racingRule = new RacingRule();

        return racingRule.getWinners(cars)
                .stream()
                .map(car -> car.getStatus().name())
                .toList();
    }
}
