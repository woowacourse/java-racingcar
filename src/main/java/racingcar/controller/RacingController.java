package racingcar.controller;

import java.util.List;
import racingcar.RacingCarContext;
import racingcar.model.car.Car;
import racingcar.model.car.CarFactory;
import racingcar.model.car.Cars;
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
        List<Car> winningCars = track.getCars().getCars();
        outputView.printOutputFormat(TRACK_FORMATTER.formatWinnerCars(winningCars));
    }

    public void terminatedByException(String errorMessage) {
        outputView.printOutputFormat(errorMessage);
    }

    public void terminated() {
        outputView.printOutputFormat(ErrorMessage.UNEXPECTED_ERROR.message());
    }
}
