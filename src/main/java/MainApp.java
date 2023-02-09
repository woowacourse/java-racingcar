import application.RacingGameApplication;
import config.RacingGameAppFactory;

public class MainApp {
    public static void main(String[] args) {
        RacingGameAppFactory racingGameAppFactory = new RacingGameAppFactory();
        RacingGameApplication racingGameApplication = racingGameAppFactory.generateApp();

        racingGameApplication.run();
    }
}
