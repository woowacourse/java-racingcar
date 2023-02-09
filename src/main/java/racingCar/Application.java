package racingCar;

import racingCar.util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController();
        controller.run(new RandomNumberGenerator());
    }
}
