package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.RandomMovement;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingApp {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        Race race = new Race(carNames);
        int trialNumbers = InputView.inputNumberOfTrial();
        for (int i = 0; i < trialNumbers; i++) {
            race.startRoundAndSaveSnapshot();
        }
        OutputView.printRounds(carNames, race.getSnapshots());
        OutputView.printWinners(race.getWinners());
    }
}