package racingcar.controller;

import racingcar.model.car.CarFactory;
import racingcar.model.car.Cars;
import racingcar.model.track.Track;
import racingcar.model.trialtimes.TrialTimes;
import racingcar.util.ErrorMessage;
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
        return new Track(cars, trialTimes);
    }

    private CarNamesRequest requestCarNames() {
        return inputView.getCarNames();
    }

    private int requestTrialTimes() {
        TrialTimesRequest trialTimesRequest = inputView.getTrialTimes();

        return trialTimesRequest.getTrialTimes();
    }

    public void startRace(Track track) {
        outputView.printOutputFormat(track.carsPositionFormat());
        while (track.runnable()) {
            track.race();
            outputView.printOutputFormat(track.carsPositionFormat());
        }
    }

    public void concludeWinner(Track track) {
        outputView.printOutputFormat(track.winingCarsFormat());
    }

    public void terminatedByException(String errorMessage) {
        outputView.printOutputFormat(errorMessage);
    }

    public void terminated() {
        outputView.printOutputFormat(ErrorMessage.UNEXPECTED_ERROR.message());
    }
}
