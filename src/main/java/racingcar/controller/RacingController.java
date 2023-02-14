package racingcar.controller;

import racingcar.exception.CustomException;
import racingcar.model.car.Cars;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.track.Track;
import racingcar.view.inputview.InputView;
import racingcar.view.outputview.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(final MovingStrategy movingStrategy) {
        Cars cars = makeCars(movingStrategy);
        String trialTimes = inputView.inputTrialTimes();
        Track track = makeTrack(cars, trialTimes);

        outputView.printCurrentCarsPosition(cars);
        startRace(track);
        concludeWinner(track);
    }

    private Cars makeCars(final MovingStrategy movingStrategy) {
        try {
            return new Cars(inputView.inputCarNames(), movingStrategy);
        } catch (CustomException customException) {
            terminated(customException);
        }

        return makeCars(movingStrategy);
    }

    private Track makeTrack(final Cars cars, String trialTimes) {
        try {
            return new Track(cars, trialTimes);
        } catch (CustomException customException) {
            terminated(customException);
        }

        return makeTrack(cars, trialTimes);
    }

    public void startRace(final Track track) {
        while (track.runnable()) {
            Cars cars = track.race();
            outputView.printCurrentCarsPosition(cars);
        }
    }

    public void concludeWinner(final Track track) {
        outputView.printWinnerCars(track.findWinner());
    }

    public void terminated(final CustomException customException) {
        outputView.printErrorMessage(customException.getErrorNumber());
    }
}
