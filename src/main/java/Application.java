import controller.RaceController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        RaceController raceController = new RaceController(new InputView(), new OutputView());
        raceController.play();
    }
}
