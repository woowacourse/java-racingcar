import controller.RacingController;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        try {
            InputView input = new InputView();

            final RacingController racingGame = new RacingController(
                    input.getCarNames(),
                    input.getTryCount()
            );

            racingGame.race();

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
