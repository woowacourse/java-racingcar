import controller.CarRacing;
import domain.Cars;
import view.InputView;
import view.OutputView;

public class RacingApplication {

    public static void main(String[] args) {
        final var carRacing = new CarRacing(new InputView(), new OutputView());
        Cars cars = carRacing.start();
        carRacing.announceWinners(cars);
    }
}
