import controller.RacingController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            final RacingController racingGame = new RacingController(
                    new InputView(),
                    new OutputView()
            );

            racingGame.race();

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
