import racing.RacingGame;
import racing.domain.Cars;
import racing.util.Converter;
import racing.validate.InputVerifier;
import racing.view.input.InputView;
import racing.view.output.OutputView;

public class Application {
    static RacingGame racingGame = new RacingGame();

    public static void main(String[] args) {
        Cars cars = initializeCar();
        int count = getCount();
        execute(count, cars);
    }

    private static Cars initializeCar() {
        String[] names = getNames();
        return makeCars(names);
    }

    private static String[] getNames() {
        String inputNames = InputView.inputCarName();
        InputVerifier.validateNameLength(inputNames);
        return Converter.splitInput(inputNames);
    }

    private static Cars makeCars(String[] names) {
        return racingGame.createCars(names);
    }

    private static int getCount() {
        String inputCount = InputView.inputCount();
        return Converter.convertType(inputCount);
    }

    private static void execute(int count, Cars cars) {
        OutputView.printPhrase();
        while (count-- > 0) {
            racingGame.move(cars);
            OutputView.printStep(cars);
        }
        RacingGame.printResult(cars);
    }
}