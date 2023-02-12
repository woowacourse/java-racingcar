import application.RacingGameApplication;
import config.RacingGameAppFactory;

public class MainApp {
    public static void main(String[] args) {
        RacingGameApplication racingGameApplication = RacingGameAppFactory.generate();
        racingGameApplication.run();
    }
}
