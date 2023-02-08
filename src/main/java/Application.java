import controller.GameController;
import domain.Car;
import domain.repository.CarRepository;
import service.GameService;
import service.validate.InputVerifier;
import view.input.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String inputNames = InputView.inputCarName();
        String[] names = InputVerifier.splitInput(inputNames);

        GameService gameService = new GameService(new CarRepository());
        GameController gameController = new GameController(gameService);

        List<Car> cars = gameController.getCars(names);


        String inputCount = InputView.inputCount();
        int count = InputVerifier.convert(inputCount);
        System.out.println("count = " + count);
    }
}
