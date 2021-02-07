package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private CarController carController;
    private InputView inputView;
    private OutputView outputView;

    public RacingController() {
        carController = new CarController();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        inputCarNames();
        int time = inputTime();
        carController.race(time, outputView);
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

    public int inputTime() {
        try {
            outputView.askTime();
            int time = inputView.inputTime();
            return time;
        } catch (RuntimeException e) {
            return inputTime();
        }
    }
}
