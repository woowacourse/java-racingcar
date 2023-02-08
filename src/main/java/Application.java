import controller.GameController;
import domain.Car;
import domain.repository.CarRepository;
import service.GameService;
import service.validate.InputVerifier;
import util.Converter;
import view.input.InputView;

import java.util.List;

public class Application {
    static GameService gameService = new GameService(new CarRepository());
    static GameController gameController = new GameController(gameService);

    public static void main(String[] args) {
        String[] names = getNames();
        List<Car> cars = makeCars(names);
        int count = getCount();
    }

    private static String[] getNames() {
        String inputNames = InputView.inputCarName();
        String[] names = Converter.splitInput(inputNames);
        InputVerifier.validateNameLength(names);
        return names;
    }

    private static List<Car> makeCars(String[] names) {
        return gameController.getCars(names);
    }

    private static int getCount() {
        String inputCount = InputView.inputCount();
        InputVerifier.checkInputTypeIsNumber(inputCount);
        return Converter.convertType(inputCount);
    }
}
