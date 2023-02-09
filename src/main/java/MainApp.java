import application.RacingGameApplication;
import domain.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class MainApp {
    public static void main(String[] args) {
        RacingGameApplication racingGameApplication =
                new RacingGameApplication(new InputView(), new OutputView(), new RandomNumberGenerator());
        racingGameApplication.run();
    }
}
