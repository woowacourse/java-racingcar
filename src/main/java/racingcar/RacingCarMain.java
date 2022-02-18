package racingcar;

import java.util.List;
import racingcar.controller.RacingCarController;
import racingcar.domain.RacingGame;

public class RacingCarMain {
    public static final RacingCarController controller = new RacingCarController();

    public static void main(String[] args) {
        List<String> carNames = controller.getCarNames();
        Integer round = controller.getRound();
        RacingGame racingGame = controller.initRacing(carNames, round);
        controller.printRoundResult(racingGame.race());
        List<String> winnerNames = controller.getWinnerNames(racingGame);
        controller.printWinners(winnerNames);
    }
}
