import config.AppConfig;
import controller.RacingCarController;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCarController racingCarController = AppConfig.config();
        racingCarController.run();
    }
}
