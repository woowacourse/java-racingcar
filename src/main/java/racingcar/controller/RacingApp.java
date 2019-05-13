package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.RoundResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingApp {
    public static void main(String[] args) {
        Race race = null;
        while (race == null) {
            try {
                race = new Race(InputView.inputCarNames());
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
        List<RoundResult> raceResult = race.startRace(getNumOfRounds());
        OutputView.printRaceResult(raceResult);
        OutputView.printWinners(raceResult.get(raceResult.size() - 1).getWinners());
    }

    private static int getNumOfRounds() {
        try {
            int numOfTrials = InputView.inputNumberOfTrial();
            validateNumOfTrial(numOfTrials);
            return numOfTrials;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다.");
            return getNumOfRounds();
        }
    }

    private static void validateNumOfTrial(int number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }
    }
}