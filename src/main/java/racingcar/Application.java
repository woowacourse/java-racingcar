package racingcar;

<<<<<<< HEAD
=======
import racingcar.controller.Controller;
>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071
import racingcar.view.OutputView;

public class Application {
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        try {
<<<<<<< HEAD
            RacingCarApplication racingCarApplication = new RacingCarApplication();
            racingCarApplication.playingGame();
            racingCarApplication.printFinalResult();
=======
            Controller controller = new Controller();
            controller.startRacing();
            controller.endRacing();
>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071
        } catch (Exception error) {
            outputView.printError(error);
        }
    }
<<<<<<< HEAD

=======
>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071
}
