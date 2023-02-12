package racingcar;

import racingcar.controller.CarRaceController;

public class Application {
    public static void main(String[] args) {
        CarRaceController carRaceController = new CarRaceController();
        carRaceController.race();
    }
}
