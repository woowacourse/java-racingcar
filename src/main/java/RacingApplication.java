import io.InputView;
import io.OutputView;
import io.validator.InputValidator;

public class RacingApplication {

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(new InputView(new InputValidator()), new OutputView());
        carRacing.start();
    }
}
