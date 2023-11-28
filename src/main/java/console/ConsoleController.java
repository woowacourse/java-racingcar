package console;

import domain.core.Car;
import domain.core.RacingGame;
import domain.core.RandomNumberGenerator;
import domain.vo.Record;
import java.util.List;

public class ConsoleController {

    private final InputReader reader = new InputReader();
    private final ConsolePrinter printer = new ConsolePrinter();

    public void playGame() {
        List<String> cars = reader.readCarNames();
        int tryCount = reader.readTryCount();
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator(), cars, tryCount);

        List<List<Record>> playRecords = racingGame.playGame();
        printer.printPlayRecords(playRecords);

        List<Car> winners = racingGame.winners();
        printer.printWinners(winners);
    }
}
