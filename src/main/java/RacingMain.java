import domain.Car;
import domain.Count;
import domain.RaceCars;
import domain.RacingGame;
import util.ExceptionHandler;
import view.View;

import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        final View view = new View();

        final RaceCars raceCars = ExceptionHandler.run(view::readCars);
        final Count count = ExceptionHandler.run(view::readCount);

        final RacingGame racingGame = new RacingGame(raceCars, count);
        racingGame.race();

        view.printResultNotice();
        view.printRace(racingGame);

        final List<Car> winners = racingGame.judgeWinners();
        view.printWinners(winners);
    }
}
