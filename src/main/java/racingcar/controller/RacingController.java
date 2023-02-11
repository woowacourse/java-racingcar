package racingcar.controller;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.CarFactory;
import racingcar.model.car.Cars;
import racingcar.model.track.Track;
import racingcar.model.trialtimes.TrialTimes;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.dto.CarNamesRequest;
import racingcar.view.dto.TrialTimesRequest;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarFactory carFactory;

    public RacingController(InputView inputView, OutputView outputView, CarFactory carFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carFactory = carFactory;
    }

    public Track generateRacingTrack() {
        CarNamesRequest carNamesRequest = requestCarNames();
        Cars cars = carFactory.generateCarsFromCarNames(carNamesRequest);

        int trialTimesCount = requestTrialTimes();
        TrialTimes trialTimes = new TrialTimes(trialTimesCount);
        printCarsInitPositions(cars);
        return new Track(cars, trialTimes);
    }

    private void printCarsInitPositions(Cars cars) {
        outputView.printCarsPosition(cars);
    }

    private CarNamesRequest requestCarNames() {
        return inputView.getCarNames();
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
