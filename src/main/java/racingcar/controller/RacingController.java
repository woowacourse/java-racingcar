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
        outputView.askCarName();
        String[] name = inputView.inputCarName();
        outputView.askTime();
        int time = inputView.inputTime();
        // TODO : 자동차 이름 입력
//        carController.createCars(names);
    }
}
