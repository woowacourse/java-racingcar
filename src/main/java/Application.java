import controller.RacingController;
import java.util.List;
import model.Cars;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingController controller = new RacingController(new InputView(), new OutputView());
        controller.play(3, Cars.fromNames(List.of("pobi", "hell")));
    }
}
