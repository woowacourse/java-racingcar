package racingcar.controller;

import racingcar.RacingCarContext;
import racingcar.model.car.CarFactory;
import racingcar.model.car.Cars;
import racingcar.model.car.WinnerCars;
import racingcar.model.track.Track;
import racingcar.model.trialtimes.TrialTimes;
import racingcar.util.ErrorMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.dto.CarNamesRequest;
import racingcar.view.dto.TrialTimesRequest;
import racingcar.view.formatter.track.TrackStateFormatter;

public class RacingController {
    private static final TrackStateFormatter TRACK_FORMATTER = RacingCarContext.getTrackStateFormatter();

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
        Cars carsOnTrack = track.getCars();
        printInitialCarsPositions(carsOnTrack);
        while (track.runnable()) {
            track.race();
            String carsPositionFormat = TRACK_FORMATTER.formatCarsPosition(carsOnTrack);
            outputView.printOutputFormat(carsPositionFormat);
        }
    }

    private void printInitialCarsPositions(Cars cars) {
        outputView.printOutputFormat(TRACK_FORMATTER.formatCarsPosition(cars));
    }

    public void concludeWinner(Track track) {
        WinnerCars winnerCars = WinnerCars.fromCars(track.getCars());
        String winnerCarsFormat = TRACK_FORMATTER.formatWinnerCars(winnerCars);
        outputView.printOutputFormat(winnerCarsFormat);
    }

    public void terminatedByException(String errorMessage) {
        outputView.printOutputFormat(errorMessage);
    }

    public void terminated() {
        outputView.printOutputFormat(ErrorMessage.UNEXPECTED_ERROR.message());
    }
}
