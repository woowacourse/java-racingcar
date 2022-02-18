package racingcar;

import java.util.List;
import racingcar.controller.RacingCarController;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class RacingCarMain {
    public static final RacingCarController controller = new RacingCarController();

    public static void main(String[] args) {
        List<Car> cars = controller.getCarNames();
        int round = controller.getRound();
        RacingGame racingGame = new RacingGame(cars);
        raceAndPrintResult(round, racingGame);
        controller.printWinners(racingGame.findWinners());
    }

    private static void raceAndPrintResult(int round, RacingGame racingGame) {
        controller.printRoundResultMessage();
        for (int i = 0; i < round; i++) {
            List<Car> raceResult = racingGame.race();
            controller.printRoundResult(raceResult);
        }
    }
}
