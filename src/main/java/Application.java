import controller.Controller;
import domain.Cars;
import service.Service;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        Cars cars = new Cars(new ArrayList<>(), new RandomNumberGenerator());
        Service service = new Service(cars);

        Controller controller = new Controller(outputView, inputView, service);
        controller.run();
    }
}
