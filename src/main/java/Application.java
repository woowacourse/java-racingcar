import controller.RacingGameController;
import domain.RandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        RacingGameController racingController = new RacingGameController();
        racingController.run();
    }
}
