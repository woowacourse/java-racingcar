package racingcar.controller;

import racingcar.view.InputView;

public class RacingController {
    private CarController carController;
    private InputView inputView;

    public RacingController() {
        carController = new CarController();
        inputView = new InputView();
    }

    public void run() {
//        String name = inputView.inputCarName(); // TODO : 자동차 입력 기능 구현
        // TODO : 메뉴 표시
        // TODO : 자동차 이름 입력
//        carController.createCars(names);
    }
}
