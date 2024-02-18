import controller.RacingCarController;
import domain.RacingCarFactory;
import domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new RandomNumberGenerator(), new RacingCarFactory());
        racingCarController.start();
    }
}
