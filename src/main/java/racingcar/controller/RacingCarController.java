package racingcar.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
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

    public void printRoundResult(Map<Integer, List<CarDto>> raceResult) {
        OutputView.printRoundResult(raceResult);
    }

    public void printWinners(List<String> winnerNames) {
        OutputView.printWinners(winnerNames);
    }

    public RacingGame initRacing(List<String> carNames, int round) {
        return new RacingGame(carNames, round);
    }

    public List<String> getWinnerNames(RacingGame racingGame) {
        return racingGame.findWinners()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
