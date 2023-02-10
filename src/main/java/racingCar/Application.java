package racingCar;

import racingCar.controller.RacingCarController;
import racingCar.util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController();
        controller.run();
    }
}
