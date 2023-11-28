package console;

import domain.Car;
import domain.Cars;
import domain.Name;
import domain.RacingGame;
import domain.RandomNumberGenerator;
import domain.Record;
import domain.TryCount;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleController {

    private final InputReader reader = new InputReader();
    private final ConsolePrinter printer = new ConsolePrinter();

    public void playGame() {
        Cars cars = makeCars();
        TryCount tryCount = readTryCount();
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator(), cars);

        List<List<Record>> playRecords = racingGame.playGame(tryCount);
        printer.printPlayRecords(playRecords);

        List<Car> winners = racingGame.winners();
        printer.printWinners(winners);
    }

    private Cars makeCars() {
        List<String> inputNames = reader.readCarNames();
        List<Car> cars = inputNames.stream()
                .map(Name::new)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    private TryCount readTryCount() {
        int inputTryCount = reader.readTryCount();
        
        return new TryCount(inputTryCount);
    }
}
