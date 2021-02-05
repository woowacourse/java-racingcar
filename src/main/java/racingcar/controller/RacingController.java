package racingcar.controller;

public class RacingController {
    private CarController carController;

    public RacingController() {
        carController = new CarController();
    }

    public void run() {
        String names = "임시";
        // TODO : 메뉴 표시
        // TODO : 자동차 이름 입력
        carController.createCars(names);
    }
}
