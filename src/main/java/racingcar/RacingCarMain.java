package racingcar;

import java.util.List;
import java.util.Map;
import racingcar.controller.RacingCarController;
import racingcar.domain.CarDto;
import racingcar.domain.RacingGame;

public class RacingCarMain {
    public static final RacingCarController controller = new RacingCarController();

    public static void main(String[] args) {
        List<String> carNames = controller.getCarNames();
        Integer round = controller.getRound();
        RacingGame racingGame = controller.initRacing(carNames, round);
        Map<Integer, List<CarDto>> raceResults = controller.getRaceResults(racingGame);
        controller.printRaceResults(raceResults);
        List<String> winnerNames = controller.getWinnerNames(racingGame);
        controller.printWinners(winnerNames);
    }
}
