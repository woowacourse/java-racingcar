import controller.GameController;
import domain.Car;
import domain.repository.CarRepository;
import service.GameService;
import service.validate.InputVerifier;
import util.Converter;
import view.input.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String inputNames = InputView.inputCarName();
        String[] names = Converter.splitInput(inputNames);
        InputVerifier.validateNameLength(names);

        GameService gameService = new GameService(new CarRepository());
        GameController gameController = new GameController(gameService);

        List<Car> cars = gameController.getCars(names);


        String inputCount = InputView.inputCount();
        InputVerifier.checkInputTypeIsNumber(inputCount);
        int count = Converter.convertType(inputCount);


        System.out.println("count = " + count);
    }
}
