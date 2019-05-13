package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.RandomMovement;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingApp {
    public static void main(String[] args) {
        final Race race = new Race(InputView.inputCarNames(), new RandomMovement());
        final int numberOfTrials = InputView.inputNumberOfTrials();
        OutputView.printRaceStartMessage();
        for (int i = 0; i < numberOfTrials; i++) {
            OutputView.printEachRound((race.startEachRound()));
        }
        OutputView.printWinners(race.getWinners());
    }
}