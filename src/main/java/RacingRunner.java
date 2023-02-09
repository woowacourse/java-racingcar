import controller.CarController;
import java.util.Scanner;
import service.CarService;
import utils.RacingRandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingRunner {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        CarService carService = new CarService();
        CarController carController = new CarController(inputView, outputView, carService);

        carController.run(new RacingRandomNumberGenerator());
    }
}
