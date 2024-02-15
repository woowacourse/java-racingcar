import domain.CarRacing;
import io.InputView;
import io.OutputView;

public class RacingApplication {

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(new InputView(), new OutputView());
        carRacing.start();
    }
}
