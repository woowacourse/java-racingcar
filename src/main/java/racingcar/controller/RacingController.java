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
        CarNames carNames = requestCarNames();
        Cars cars = setUpCars(carNames, movingStrategy);

        int trialTime = requestTrialTimes();
        outputView.printCarsPosition(cars);

        return new Track(cars, trialTime);
    }

    private CarNames requestCarNames() {
        return inputView.getCarNames();
    }

    private Cars setUpCars(CarNames carNames, MovingStrategy movingStrategy) {
        List<Car> carsByNames = carNames.toSplitCarNames().stream()
                .map(carName -> new Car(carName, movingStrategy))
                .collect(Collectors.toList());

        return new Cars(carsByNames);
    }

    private int requestTrialTimes() {
        TrialTimes trialTimes = inputView.getTrialTimes();

        return trialTimes.getTrialTimes();
    }

    public void startRace(Track track) {
        while (track.runnable()) {
            Cars cars = track.race();
            outputView.printCarsPosition(cars);
        }
    }

    public void concludeWinner(Track track) {
        List<Car> winnerCars = track.findWinner();
        outputView.printWinnerCars(winnerCars);
    }

    public void terminated(String errorMessage) {
        outputView.printErrorMessage(errorMessage);
    }
}
