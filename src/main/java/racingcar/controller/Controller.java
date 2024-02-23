package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarDistance;
import racingcar.domain.car.Cars;
import racingcar.domain.RacingCount;
import racingcar.domain.power.PowerGenerator;
import racingcar.domain.power.RandomPowerGenerator;
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
        final RandomPowerGenerator powerGenerator = new RandomPowerGenerator();

        playRacing(cars, racingCount, powerGenerator);
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

    private void playRacing(final Cars cars, final RacingCount racingCount, PowerGenerator powerGenerator) {
        outputView.printResultMessageTitle();
        int playedCount = 0;
        while (!racingCount.isFinish(playedCount)) {
            cars.race(powerGenerator);
            List<CarStatus> carStatuses = getCarStatuses(cars);
            outputView.printRacingResult(carStatuses);
            playedCount++;
        }
    }

    private static List<CarStatus> getCarStatuses(Cars cars) {
        List<CarStatus> carStatuses = cars.getCars()
                .stream()
                .map(car -> new CarStatus(car.getName(), car.getDistance()))
                .toList();
        return carStatuses;
    }

    private List<String> getWinners(final Cars cars) {
        final CarDistance maxDistance = cars.getMaxDistance();
        final List<Car> winners = cars.findCarsAtDistance(maxDistance);
        return winners.stream()
                .map(Car::getName)
                .toList();
    }
}
