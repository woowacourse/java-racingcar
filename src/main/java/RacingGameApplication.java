import controller.RacingGameController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import view.InputValidator;
import view.InputView;
import view.OutputView;

public class RacingGameApplication {

    public static void main(String[] args) throws IOException {
        RacingGameController racingGameController = new RacingGameController(inputView(), outputView());
        racingGameController.run();
    }

    private static InputView inputView() {
        return new InputView(inputValidator(), bufferedReader());
    }

    private static InputValidator inputValidator() {
        return new InputValidator();
    }

    private static BufferedReader bufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
