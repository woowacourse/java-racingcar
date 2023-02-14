package racingCar;

import racingCar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController controller = new RacingController();
        controller.run();
    }
}
