import controller.CarRacing;
import view.InputView;
import view.OutputView;

public class RacingApplication {

    public static void main(String[] args) {
        final var carRacing = new CarRacing(new InputView(), new OutputView());

        final var cars = carRacing.start();
        carRacing.announceWinners(cars);
    }
}
