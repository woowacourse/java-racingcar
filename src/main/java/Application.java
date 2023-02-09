import controller.RacingController;
import domain.RandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = new RacingController(new RandomNumberGenerator());
        racingController.run();
    }
}
