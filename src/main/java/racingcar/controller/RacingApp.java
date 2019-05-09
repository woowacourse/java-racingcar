package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.RandomMovement;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingApp {
    private static List<String> carNames;
    private static Race race;

    public static void main(String[] args) {
        carNames = InputView.inputCarNames();
        race = new Race(carNames, new RandomMovement());
        int trialNumbers = InputView.inputNumberOfTrial();
        for (int i = 0; i < trialNumbers; i++) {
            race.startRoundAndSaveSnapshot();
        }
        OutputView.printRounds(carNames, race.getSnapshots());
        OutputView.printWinners(race.getWinners());
    }
}