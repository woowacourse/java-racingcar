package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingApp {
    public static void main(String[] args) {
        final Race race = new Race(InputView.inputCarNames(), InputView.inputNumberOfTrials());
        OutputView.printRaceStartMessage();
        while (race.hasNext()) {
            OutputView.printEachRound((race.next()));
        }
        OutputView.printWinners(race.finish());
    }
}