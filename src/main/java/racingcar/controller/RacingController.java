package racingcar.controller;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.track.Track;
import racingcar.model.trialtimes.TrialTimes;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.dto.CarNamesRequest;
import racingcar.view.dto.TrialTimesRequest;

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
        CarNamesRequest carNamesRequest = requestCarNames();
        Cars cars = setUpCars(carNamesRequest, movingStrategy);

        int trialTimesCount = requestTrialTimes();
        TrialTimes trialTimes = new TrialTimes(trialTimesCount);
        outputView.printCarsPosition(cars);

        return new Track(cars, trialTimes);
    }

    private CarNamesRequest requestCarNames() {
        return inputView.getCarNames();
    }

    private Cars setUpCars(CarNamesRequest carNamesRequest, MovingStrategy movingStrategy) {
        List<Car> carsByNames = carNamesRequest.toSplitCarNames().stream()
                .map(carName -> new Car(carName, movingStrategy))
                .collect(Collectors.toList());

        return new Cars(carsByNames);
    }

    private int requestTrialTimes() {
        TrialTimesRequest trialTimesRequest = inputView.getTrialTimes();

        return trialTimesRequest.getTrialTimes();
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
