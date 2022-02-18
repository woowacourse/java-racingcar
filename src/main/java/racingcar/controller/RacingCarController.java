package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public List<Car> getCarNames() {
        return InputView.getCars();
    }

    public int getRound() {
        return InputView.getRound();
    }

    public void printRoundResultMessage() {
        OutputView.printRoundResultMessage();
    }

    public void printRoundResult(List<Car> raceResult) {
        OutputView.printRoundResult(raceResult);
    }

    public void printWinners(List<Car> winners) {
        OutputView.printWinners(winners);
    }
}
