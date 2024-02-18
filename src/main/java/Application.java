import controller.RacingCarController;
import domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new RandomNumberGenerator());
        racingCarController.start();
    }
}
