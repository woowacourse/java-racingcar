package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.track.Track;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(final MovingStrategy movingStrategy) {
        Cars cars = new Cars(inputView.inputCarNames(), movingStrategy);
        String trialTimes = inputView.inputTrialTimes();
        Track track = new Track(cars, trialTimes);

        outputView.printCurrentCarsPosition(cars);
        startRace(track);
        concludeWinner(track);
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

    public void terminated(final String errorMessage) {
        outputView.printErrorMessage(errorMessage);
    }
}
