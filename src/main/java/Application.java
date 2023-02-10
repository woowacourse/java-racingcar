import racing.RacingGame;
import racing.domain.Cars;
import racing.util.Converter;
import racing.validate.InputVerifier;
import racing.view.input.InputView;
import racing.view.output.OutputView;

public class Application {
    static RacingGame racingGame = new RacingGame();

    public static void main(String[] args) {
        String[] names = getNames();
        Cars cars = makeCars(names);
        int count = getCount();
        OutputView.printPhrase();
        execute(count, cars);
        RacingGame.printResult(cars);
    }

    private static String[] getNames() {
        String inputNames = InputView.inputCarName();
        String[] names = Converter.splitInput(inputNames);
        InputVerifier.validateNameLength(names);
        return names;
    }

    private static Cars makeCars(String[] names) {
        return racingGame.createCars(names);
    }

    private static int getCount() {
        String inputCount = InputView.inputCount();
        InputVerifier.checkInputTypeIsNumber(inputCount);
        return Converter.convertType(inputCount);
    }

    private static void execute(int count, Cars cars) {
        for (int step = 0; step < count; step++) {
            racingGame.move(cars);
            OutputView.printStep(cars);
            System.out.println();
        }
    }
}
