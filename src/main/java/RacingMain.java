import domain.Car;
import domain.Count;
import domain.RaceCars;
import domain.RacingGame;
import util.ExceptionHandler;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final RaceCars raceCars = ExceptionHandler.run(inputView::readCars);
        final Count count = ExceptionHandler.run(inputView::readCount);

        final RacingGame racingGame = new RacingGame(raceCars, count);
        racingGame.race();

        final OutputView outputView = new OutputView();
        outputView.printResultNotice();
        outputView.printRace(racingGame);

        final List<Car> winners = racingGame.judgeWinners();
        outputView.printWinners(winners);
    }
}
