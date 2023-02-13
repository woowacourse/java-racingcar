import controller.RaceController;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        RaceController raceController = new RaceController(new InputView(), new OutputView(),
            new RandomNumberGenerator());
        raceController.play();
    }
}
