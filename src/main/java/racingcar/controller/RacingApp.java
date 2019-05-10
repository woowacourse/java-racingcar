package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingApp {
    public static void main(String[] args) {
        Race race = InputView.inputCarNames();
        OutputView.printRounds(InputView.inputNumberOfTrial(), race);
        OutputView.printWinners(race.getWinners());
    }
}