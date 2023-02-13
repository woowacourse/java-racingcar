import controller.Controller;
import domain.Cars;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        Cars cars = new Cars(new ArrayList<>(), RandomNumberGenerator.makeInstance());

        Controller controller = new Controller(outputView, inputView, cars);
        controller.run();
    }
}
