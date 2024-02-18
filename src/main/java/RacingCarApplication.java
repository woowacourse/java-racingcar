import config.AppConfig;
import controller.Controller;

public class RacingCarApplication {

    public static void main(String[] args) {
        Controller controller = AppConfig.config();
        controller.run();
    }
}
