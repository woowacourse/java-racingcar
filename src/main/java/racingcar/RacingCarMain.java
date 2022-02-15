package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarMain {
    public static void main(String[] args) {
        List<Car> cars = InputView.getCars();
        int round = InputView.getRound();
        RacingGame racingGame = new RacingGame(cars);
        raceAndPrintResult(round, racingGame);
        OutputView.printWinners(racingGame.findWinners());
    }

    private static void raceAndPrintResult(int round, RacingGame racingGame) {
        OutputView.printRoundResultMessage();
        for (int i = 0; i < round; i++) {
            List<Car> raceResult = racingGame.race();
            OutputView.printRoundResult(raceResult);
        }
    }
}
