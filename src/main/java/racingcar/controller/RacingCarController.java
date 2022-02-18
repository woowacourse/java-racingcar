package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public List<String> getCarNames() {
        return InputView.getCarNames();
    }

    public Integer getRound() {
        return InputView.getRound();
    }

    public void printRoundResult(Map<Integer, List<Car>> raceResult) {
        OutputView.printRoundResult(raceResult);
    }

    public void printWinners(List<Car> winners) {
        OutputView.printWinners(winners);
    }

    public RacingGame initRacing(List<String> carNames, int round) {
        return new RacingGame(carNames, round);
    }
}
