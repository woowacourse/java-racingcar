import controller.RacingCarController;
import domain.RandomNumberGenerator;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new RandomNumberGenerator());
        racingCarController.start();
    }
}
