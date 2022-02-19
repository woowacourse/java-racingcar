package racingcar.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.RacingGame;
import racingcar.view.CarNamesInputView;
import racingcar.view.RaceResultOutputView;
import racingcar.view.WinnersOutputView;
import racingcar.view.RoundInputView;

public class RacingCarController {

    public List<String> getCarNames() {
        return CarNamesInputView.getCarNames();
    }

    public Integer getRound() {
        return RoundInputView.getRound();
    }

    public void printRaceResults(Map<Integer, List<CarDto>> raceResult) {
        RaceResultOutputView.printRaceResults(raceResult);
    }

    public void printWinners(List<String> winnerNames) {
        WinnersOutputView.printWinners(winnerNames);
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

    public Map<Integer, List<CarDto>> getRaceResults(RacingGame racingGame) {
        return racingGame.race();
    }
}
