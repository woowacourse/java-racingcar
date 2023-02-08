package racingcar.controller;

import racingcar.model.car.Cars;
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

    public void startGame() {
        Cars cars = requestCars();
        int trialTime = requestTrialTime();

        Track track = new Track(cars, trialTime);
    }

    private Cars requestCars() {
        CarNames carNames = inputView.getCarNames();

        return new Cars(carNames.toCarNameList());
    }


    private int requestTrialTime() {
        TrialTimes trialTimes = inputView.getTrialTimes();

        return trialTimes.getTrialTimes();
    }
}
