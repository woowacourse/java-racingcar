import controller.RacingCarController;
import domain.RandomNumberUtil;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();
        racingCarController.start();
    }
}
