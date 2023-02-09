import application.RacingGameApplication;
import domain.RandomNumberGenerator;
import view.InputView;
import view.InputViewProxy;
import view.OutputView;

public class MainApp {
    public static void main(String[] args) {
        RacingGameApplication racingGameApplication =
                new RacingGameApplication(initInputView(), new OutputView(), new RandomNumberGenerator());
        racingGameApplication.run();
    }

    private static InputView initInputView() {
        return new InputViewProxy(new InputView());
    }
}
