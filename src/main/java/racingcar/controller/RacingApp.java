package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingApp {
    public static void main(String[] args) {
        final Race race = new Race(InputView.inputCarNames());
        final int numberOfTrials = InputView.inputNumberOfTrials();
        OutputView.printRaceStartMessage();
        for (int i = 0; i < numberOfTrials; i++) {
            OutputView.printEachRound((race.startEachRound()));
        }
        OutputView.printWinners(race);
    }
}