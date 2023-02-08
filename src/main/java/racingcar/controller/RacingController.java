package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.model.car.MovingStrategy;
import racingcar.model.track.Track;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.dto.CarNames;
import racingcar.view.dto.TrialTimes;

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

        return Cars.from(carNames.toCarNameList(), movingStrategy);
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
