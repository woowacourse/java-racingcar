package racingcar.controller;

import racingcar.domain.RaceTrials;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final CarController carController;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        carController = new CarController();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        inputCarNames();
        RaceTrials trials = inputTrials();
        carController.race(trials.getTrials(), outputView);
        carController.showWinners(outputView);
    }

    public void inputCarNames() {
        try {
            outputView.askCarName();
            String[] name = inputView.inputCarName();
            carController.createCars(name);
        } catch (RuntimeException e) {
            inputCarNames();
        }
    }

    public RaceTrials inputTrials() {
        try {
            outputView.askTime();
            return new RaceTrials(inputView.inputTime());
        } catch (RuntimeException e) {
            return inputTrials();
        }
    }
}
