package racingcar.controller;

import racingcar.domain.data.Time;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private CarController carController;

    public RacingController() {
        carController = new CarController();
    }

    public void run() {
        inputCarNames();
        startRounds(new Time(inputTime()));
        carController.showWinners();
    }

    public void inputCarNames() {
        try {
            OutputView.askCarName();
            String[] name = InputView.inputCarName();
            carController.createCars(name);
        } catch (RuntimeException e) {
            inputCarNames();
        }
    }

    public String inputTime() {
        try {
            OutputView.askTime();
            String time = InputView.inputTime();
            return time;
        } catch (RuntimeException e) {
            return inputTime();
        }
    }

    private void startRounds(Time time) {
        int current = 0;
        while (!time.isOver(current++)) {
            carController.race();
        }
    }
}
