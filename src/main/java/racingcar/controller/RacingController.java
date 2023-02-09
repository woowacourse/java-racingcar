package racingcar.controller;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.track.Track;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.dto.CarNames;
import racingcar.view.dto.TrialTimes;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Track init(MovingStrategy movingStrategy) {
        Cars cars = requestCars(movingStrategy);
        int trialTime = requestTrialTime();
        outputView.printInitialCarPosition(cars.getCarsPositionFormat());

        return new Track(cars, trialTime);
    }

    private Cars requestCars(MovingStrategy movingStrategy) {
        CarNames carNames = inputView.getCarNames();
        List<Car> cars = carNames.toCarNameList().stream()
                .map(carName -> new Car(carName, movingStrategy))
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    private int requestTrialTime() {
        TrialTimes trialTimes = inputView.getTrialTimes();

        return trialTimes.getTrialTimes();
    }

    public void startRace(Track track) {
        while (track.runnable()) {
            Cars cars = track.race();
            outputView.printCarsResult(cars.getCarsPositionFormat());
        }
    }

    public void concludeWinner(Track track) {
        Cars winnerCars = track.findWinner();
        outputView.printWinnerCars(winnerCars.getCarsWinnerFormat());
    }
}
